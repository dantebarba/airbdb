db.apartments.insert({name:'Apartment with 2 bedrooms', capacity:4});

db.apartments.find({name:'Apartment with 2 bedrooms'}).pretty();

db.apartments.insert({name:'New Apartment', capacity:3, services: ['wifi', 'ac']});

db.apartments.insert({name:'Nice apt for 6', capacity:6, services: ['parking']} );

db.apartments.insert({name:'1950s Apartment', capacity:3});

db.apartments.insert({name:'Duplex Floor', capacity:4, services: ['wifi', 'breakfast', 'laundry']});

db.apartments.find({capacity : 3});

db.apartments.find({capacity: { $gt: 3 }});

db.apartments.find({name: /.*Apartment.*/});

db.apartments.find({name: /.*Apartment.*/, capacity: { $gt: 3 }});

db.apartments.find({ services: null }, { _id: 0 });

db.apartments.update(
   { name: "Duplex Floor" },
   {
     $set: { capacity: 5 },
   }
);

db.apartments.update(
    { name: 'Nice apt for 6'},
    {$push: {'services' : 'Laundry'}}
);

db.apartments.update(
  { services: "wifi" },
  { $inc: { capacity: 1 }}
);
