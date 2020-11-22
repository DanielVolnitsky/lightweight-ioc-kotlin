# lightweight-ioc-kotlin
Spring-like lightweight IoC container implementation attempt inspired by Evgeny Borisov's https://www.youtube.com/watch?v=rd6wxPzXQvo  
Goals:
* learn and try out Kotlin
* deepen understanding of the Spring IoC container algorithm

Implemented features step by step:
1. Introduced ObjectFactory class responsible for creation of objects by receiving type, scanning the classpath, finding an implementation class and instantiating it.
2. Added possibility to specify the concrete implementation when few implementations are present on the classpath.
3. Added @InjectProperty annotation and its support via scanning the application.property file.
4. Introduced BeanConfigurator abstraction for the bean post creation processing/enhancement.
5. Added @Singleton annotation and support for it via caching of the previously created singleton beans.
6. Added @InjectBean annotation and support for it in order to specify dependencies with the annotation. 
7. Added second phase constructor support in order to enrich bean creation lifecycle.

Key abstractions:
* Application - IoC Facade
* Config - supplies appropriate bean implementation classes and bean configurators
* ObjectFactory - supplies beans ready for use
* ApplicationContext - Functional wrapper upon ObjectFactory, responsible for singletons' caching
* BeanConfigurator - BeanPostProcessor's analogy for bean post creation enhancement


