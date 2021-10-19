import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class Serializa {



    public static void main(String[] args) throws Exception {

        XmlMapper xmlMapper = new XmlMapper();
        Pessoa p1 = new Pessoa(1, "João");
        Pessoa p2 = new Pessoa(2, "Maria");
        List<Pessoa> l = new ArrayList<Pessoa>();
        l.add(p1);
        l.add(p2);
        String xml = xmlMapper.writeValueAsString(l);
        System.out.println(xml);
    }

}
