
# initialisation

## instalation de angular cli
~~~
npm install -g @angular/cli
~~~

## initialisation angular
avant la creation du projet
~~~
ng new <NOM>
~~~
dans angular.js
~~~
"outputPath": "src/main/resources/static",
~~~

## initialisation maven
comme d'hab

# configuration spring
Dans le @WebMvcConfig
~~~
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
}
~~~
Deployer le composant dans /

Ajouter un controller :
~~~
@GetMapping("/")
public String home() {
	return "index.html";
}
~~~

