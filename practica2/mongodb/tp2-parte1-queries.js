// Parte 2: Primeros pasos con MongoDB
use 'airbdb';
db.createCollection("apartments");

// 5
db.apartments.insert({name:'Apartment with 2 bedrooms', capacity:4});
db.apartments.find({name:'Apartment with 2 bedrooms'}).pretty();

// 6
db.apartments.insert({name:'New Apartment', capacity:3, services: ['wifi', 'ac']});
db.apartments.insert({name:'Nice apt for 6', capacity:6, services: ['parking']} );
db.apartments.insert({name:'1950s Apartment', capacity:3});
db.apartments.insert({name:'Duplex Floor', capacity:4, services: ['wifi', 'breakfast', 'laundry']});

db.apartments.find({capacity : 3});
db.apartments.find({capacity: { $gt: 3 }});
db.apartments.find({name: /.*Apartment.*/});
db.apartments.find({name: /.*Apartment.*/, capacity: { $gt: 3 }});
db.apartments.find({ services: null }, { _id: 0 });

// 7
db.apartments.update(
   { name: "Duplex Floor" },
   {
     $set: { capacity: 5 },
   }
);
// 8
db.apartments.update(
    { name: 'Nice apt for 6'},
    {$push: {'services' : 'Laundry'}}
);
// 9
db.apartments.update(
  { services: "wifi" },
  { $inc: { capacity: 1 }}
);

// Parte 3: Indices.
db.apartments.remove({});
load('generador.js');

// 10
db.apartments.getIndexes();

// 11
db.apartments.find({name: /.*11.*/}).explain("executionStats");
db.apartments.createIndex({name: 1});
db.apartments.find({name: /.*11.*/}).explain("executionStats");  // 2291 Documentos, 63ms.

// 12
db.apartments.find({"location" : {$geoWithin: {$geometry : {
	"type":"MultiPolygon",
	"coordinates":[[[
                    [0.210307, 51.485877],
                    [0.203326, 51.454328],
                    [0.171111, 51.441565],
                    [0.151133, 51.420431],
                    [0.159891, 51.394648],
                    [0.136931, 51.344174],
                    [0.085001, 51.316023],
                    [0.085665, 51.293085],
                    [0.058483, 51.289355],
                    [0.032881, 51.307521],
                    [0.014982, 51.291787],
                    [0.002266, 51.329138],
                    [-0.037918, 51.338705],
                    [-0.047855, 51.326511],
                    [-0.084781, 51.315885],
                    [-0.094352, 51.299355],
                    [-0.12432, 51.28676],
                    [-0.154371, 51.310254],
                    [-0.16314, 51.330243],
                    [-0.217289, 51.343388],
                    [-0.226898, 51.362595],
                    [-0.260841, 51.379556],
                    [-0.285462, 51.364251],
                    [-0.319307, 51.327812],
                    [-0.330534, 51.348421],
                    [-0.308695, 51.37545],
                    [-0.31772, 51.393668],
                    [-0.419277, 51.432353],
                    [-0.456488, 51.438107],
                    [-0.460465, 51.457035],
                    [-0.506834, 51.471057],
                    [-0.483194, 51.506646],
                    [-0.495488, 51.538333],
                    [-0.477367, 51.555254],
                    [-0.496983, 51.601163],
                    [-0.497247, 51.631654],
                    [-0.457152, 51.612291],
                    [-0.438195, 51.619892],
                    [-0.401441, 51.613166],
                    [-0.316696, 51.640532],
                    [-0.296151, 51.635444],
                    [-0.252275, 51.646561],
                    [-0.249881, 51.654611],
                    [-0.19097, 51.663982],
                    [-0.163632, 51.6824],
                    [-0.109283, 51.691743],
                    [-0.066368, 51.683843],
                    [-0.011092, 51.680867],
                    [-0.012286, 51.646227],
                    [0.062972, 51.60691],
                    [0.087118, 51.604465],
                    [0.136079, 51.6236],
                    [0.168874, 51.621417],
                    [0.22406, 51.631734],
                    [0.264299, 51.60783],
                    [0.290262, 51.564298],
                    [0.313007, 51.565816],
                    [0.331194, 51.540761],
                    [0.265319, 51.532149],
                    [0.263655, 51.517869],
                    [0.214128, 51.496039],
                    [0.210307, 51.485877]
                    ]]]
                  }
 }}}).explain("executionStats");
 // without index: documents: 50000, time: 173ms.
 // with index: documents: 18273, time: 148ms.
 db.apartments.createIndex( { "location" : "2dsphere" } );

// 13
db.getCollection('reservations').aggregate(
    [ { $sample: { size: 5 } } ]
)

// 14
    db.apartments.aggregate([
            {
                $geoNear: {
                    near: { type: "Point", coordinates: [-0.127718,  51.507451] },
                    distanceField: "dist.calculated",
                    maxDistance: 15000,
                    num: 50000,
                    spherical: true
                }
            }
        ]
    );

// 15
db.apartments.aggregate([
        {
            $geoNear: {
                near: { type: "Point", coordinates: [-0.127718,  51.507451] },
                distanceField: "dist.calculated",
                maxDistance: 15000,
                num: 50000,
                spherical: true
            }
        }
        ,{$lookup:
                {
                    from: "reservations",
                    localField: "name",
                    foreignField: "apartmentName",
                    as: "reservas"
                }
        }
    ]
);

// 16
db.apartments.aggregate([
        {
            $geoNear: {
                near: { type: "Point", coordinates: [-0.127718,  51.507451] },
                distanceField: "dist.calculated",
                maxDistance: 15000,
                num: 50000,
                spherical: true
            }
        }
        ,{$lookup:
                {
                    from: "reservations",
                    localField: "name",
                    foreignField: "apartmentName",
                    as: "reservas"
                }
        },
        {
            $addFields: {
                avgAmount: { $avg: "$reservas.amount" }
            }
        }
    ]
);