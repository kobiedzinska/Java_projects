package Logic.Validation;

import java.io.File;
import static Serwer.Serwer.getCurrState;

public class Validate {
    public static boolean isFileTxt(File file){
        String filename= file.getName();
        return filename.toLowerCase().endsWith(".txt");
    }
    public static boolean isCurrStateGood(){

        if ((getCurrState().getRozmiarX() < 3) || (getCurrState().getRozmiarY() < 3)) {
            return false;
        }
       if(getCurrState().getCount_before()<0 || getCurrState()==null){
           return false;
       }
       if(getCurrState().getLiczbaIteracji()<=0) {
           return false;
       }
       if(getCurrState().getAliveC()==null){
           return false;
       }
       if(getCurrState().getAliveC().size()!=getCurrState().getCount_before()){
           return false;
       }

        return true;
    }
}
