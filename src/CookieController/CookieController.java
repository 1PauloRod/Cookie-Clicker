package CookieController;

import CookieClicker.CookieClicker;

public class CookieController {
    private CookieClicker cookie;

    public CookieController(){
        try {
            cookie = new CookieClicker();
            cookie.open_site();
            cookie.select_language();
        }catch (Exception e){
            System.out.println("Error: Create cookie controller.");
        }
    }

    public void cookie_start(){
        try{
            int i = 0;
            while(true) {
                if (i % 1000 == 0 && i != 0) {
                    cookie.cookie_upgrade();
                }
                cookie.cookie_click();
                i++;
            }
        }catch (Exception e){
            System.out.println("Error: cookie start.");
        }
    }
}
