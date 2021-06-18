public class Main 
{
    public static void main(String[] args) 
    {
        Notification notif = new Notification(
            "hello",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin euismod eu velit et ornare Maecenas urna nunc, risus.dsfsdfasfasdfasfsdfjnaskf askfhas gdhkfua dsku fsad fkasudg fkasudgfukasfasgifugasdiuk fgasiudfa sa iaiufsdaiuf gasdifygasdifu gasdif gsadifgasdifygas fas ",
             Notification.Placement.TOPRIGHT);
        notif.display(5);
        notif.dispose();
        System.exit(0);
    }
}
