package ohtu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {

        // testejä debugatessa saattaa olla hyödyllistä testata ohjelman ajamista
        // samoin kuin testi tekee, eli injektoimalla käyttäjän syötteen StubIO:n avulla
        //
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");
        App application = ctx.getBean(App.class);
        application.run();
    }
}
