# Objetivo  
Este proyecto tiene como objetivo aplicar los fundamentos de las bibliotecas, barras de herramientas (app bars), y navegación entre actividades en Android. Se enfoca en la creación de una aplicación funcional que gestione eventos relacionados con mascotas, usando componentes modernos de la interfaz y comunicación entre actividades.

# Presentación  
El desarrollo se basa en la práctica “Libraries and App Bar”, donde se construye una aplicación con múltiples pantallas, que permite a los usuarios registrar mascotas, reportar síntomas, compartir información a través de otras apps y navegar con ayuda de una app bar con íconos interactivos. El proyecto pone en práctica la integración de librerías de diseño, intents explícitos e implícitos, y manejo de listas dinámicas.

# Desarrollo  

## Aspectos Clave Trabajados  

### Diseño de la Interfaz de Usuario:
- Uso de `ConstraintLayout` para estructurar las pantallas de forma flexible.
- Creación de formularios con `EditText`, `Button`, y `ImageView` para registrar mascotas y reportar síntomas.
- Implementación de una `Toolbar` como App Bar con íconos que responden a eventos (`notifications`, `events`, etc.).

### Manejo de Recursos:
- Configuración de íconos y cadenas de texto a través de `strings.xml` y `drawable`.
- Personalización de la App Bar con `menu.xml` y `res/menu`.

### Lógica de Negocio:
- Registro de mascotas con almacenamiento en listas dentro de `MainActivity`.
- Implementación de navegación a través de `Intent` explícitos para moverse entre pantallas.
- Uso de `Intent` implícitos para compartir información de síntomas a través de otras aplicaciones.
- Manejo de clics en íconos de la app bar para lanzar actividades o mostrar mensajes (`Toast`).

### Conexión entre la Interfaz y la Lógica:
- En `MainActivity`, se implementó el registro de mascotas con campos validados, almacenando los datos en una lista.
- Se utilizaron `Intent` explícitos para lanzar la actividad de reporte de síntomas (`SymptomActivity`) desde la barra de herramientas.
- En `SymptomActivity`, se usó un `Intent` implícito con `Intent.ACTION_SEND` para compartir el contenido de los síntomas.

## Ejemplo de Funcionamiento
1. El usuario registra una mascota en la pantalla principal.
2. Desde la App Bar, puede acceder a la pantalla de síntomas o ver notificaciones simuladas.
3. En la pantalla de síntomas, puede redactar un reporte y compartirlo con otra aplicación instalada (por ejemplo, correo o mensajería).

## Imágenes de Funcionamiento
![image](https://github.com/user-attachments/assets/baff8541-42bc-479b-9637-899570e29995)
![image](https://github.com/user-attachments/assets/f6ebf565-5d3a-4799-91dd-c1ec9f1c237a)
![image](https://github.com/user-attachments/assets/711daff3-513a-4e3e-90eb-ca539a2db7ad)
![image](https://github.com/user-attachments/assets/59c7737a-b7bd-44b6-9de7-0352cc24da97)




# Conclusión  
Este proyecto permitió poner en práctica elementos clave del desarrollo Android: uso de bibliotecas de soporte, barras de herramientas personalizadas, navegación entre actividades, intents implícitos y explícitos, así como la construcción de interfaces modernas. También destacó la importancia de separar la lógica de la interfaz y trabajar con estructuras de datos internas como listas.

# Referencias  
- Head First Android Development de Dawn Griffiths y David Griffiths, O’Reilly Media, Inc.  
- Presentación de apoyo: “Libraries and App Bar”  
- Documentación oficial de Android Developers sobre `Intent`, `Toolbar`, y `AppCompat`.

