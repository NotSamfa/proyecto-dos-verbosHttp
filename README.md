## Verbos HTTP

Los siguientes verbos son utilizados para realizar peticiones a través del **HyperText Transfer Protocol**:

- **GET**: Se usa para obtener un objeto o respuesta.
- **POST**: Se usa para enviar información con el objetivo de ser guardada.
- **PUT**: Se usa para actualizar un contenido o crearlo en caso que no exista.
- **PATCH**: Se utiliza para actualizar parte del contenido ya existente. No es necesario que sea enviado por completo.
- **HEAD**: Realiza la solicitud como _GET_ pero no recibe el cuerpo de la respuesta, solamente los encabezados de esta.


## Model

Dentro del model se usó notación de **lombok** para evitar la repetición de creación de _getters_ y _setters_. Sin embargo, fue necesario crear el constructor **GroceryItems** para la inyección de datos que se hará con fines prácticos.

**@Override** es una notación que aporta al poliformismo. SImplemente sobre-escribe el método anotado que proviene de una superclase desde una subclase. 

**@Autowired** ayuda a hacer una inyección de dependencia. Es decir, crea el objeto en cuestión y lo asocia directamente a la clase donde se le anota.

### Respecto a Service y Controller

Se ha cambiado la lógica propuesta en el problema. Define los puntos de entrada mediante el **Controller**, también cambiando el tipo de objeto que retorna el método con el fin de adaptarlo a las respuestas que se esperan en el **HTTP**. También, fue cambiada gran parte de la lógica de service, removiendo el arreglo con tal de implementar ahora la capa nueva **Repository**. Se interactúa ahora directamente con la base de datos y su lógica es simplificada gracias a esta. No se debe recorrer un arreglo para almacenar la información. También se adapta **Service** con tal de que retornen lo necesario para cada **ResponseEntity** respectivo y poder ver el contenido junto a su código de respuesta.

Para **Controller** se hace uso de la notación **RestController** es una especialización en el cual ya se espera de los metodos un retorno de entidad, no una vista como podría ser en este primero.

Con el objetivo de exponer estos métodos y ser accidedos mediante la conexión de springboot según las rutas con el protocolo **HTTP**, se usa **RequestMapping**. Como dice su nombre, mapea estos metodos para que spring por debajo pueda relacionarlos con estas peticiones respectivas.
