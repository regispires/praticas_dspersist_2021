import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Serializa2 {



    public static void main(String[] args) throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        Pessoa p1 = new Pessoa(1, "João");
        Pessoa p2 = new Pessoa(2, "Maria");
        List<Pessoa> l = new ArrayList<Pessoa>();
        l.add(p1);
        l.add(p2);
        File f = new File("pessoas.xml");
        xmlMapper.writeValue(f, l);
    }

}
