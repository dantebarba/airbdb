Parte I:

1. Base de datos: Existe

2. Tabla / relación: No existe. El modelo relacional es reemplazado por documentos.Se pierde el concepto de esquemas, por lo tanto el concepto de unión de tablas en esquemas relacionales. Los datos representados en una tabla pueden ser emulados con múltiples documentos. 

3. Fila y tupla: Las filas y tuplas no están definidas en un documento. No es necesario organizar la información de esa forma. Las BBDD no relacionales proporcionan flexibilidad a la hora de persistir las estructuras de datos.

4. Nuevamente como en el caso de las filas y tuplas, las columnas no están definidas en un documento. 

2).Aclaración, lo dicho en esta respuesta no es válido para versiones MongoDB 4.x, que garantizarán transacciones ACID. https://www.mongodb.com/blog/post/multi-document-transactions-in-mongodb 

Las transacciones en MongoDB tienen un alcance por documento. No cumplen con las especificaciones ACID que sí pueden ser alcanzadas por RDBMS. En MongoDB pueden darse problemas de integridad al trabajar con datos separados en distintos documentos.

	

3). Indices disponibles en MongoDB:

	

	- Single field: Permite la creación de un índice en cualquier campo del documento.

	- Compound Index: Permite la creación de un índice basado en múltiples campos.

	- Multikey Index: Índice creado por MongoDB automáticamente que permite acelerar la consulta a los arreglos contenidos en los documentos.

	- Geospatial Index: Índices especializados para datos de coordenadas y geolocalización.

	- Text index: Índices de texto para permitir la búsqueda de texto en una colección. 

	- Hash index: Permite indexar campos a través de una función de hash. Solo permite la búsqueda por igualdad, no por rangos.

	

4). En los modelos NoSQL no existen las restricciones de esquema. Las FK no son necesarias en un modelo de base de datos que permite almacenar la información en una estructura flexible.

	
