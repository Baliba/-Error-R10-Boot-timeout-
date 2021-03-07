  @SpringBootApplication
  @ComponentScan
	 // extends you app to pringBootServletInitializer
  public class BysAppApplication  extends SpringBootServletInitializer {

   public static void main(final String[] args) {
		SpringApplication.run(BysAppApplication.class, args);
   }
	  // add this function inthe base of your app 
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(BysAppApplication.class);
   }
}
// NB : thos new code will help you to build you app in war package if it was in jar package 
