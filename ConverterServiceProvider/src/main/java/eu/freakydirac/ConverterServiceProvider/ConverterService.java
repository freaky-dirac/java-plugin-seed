package eu.freakydirac.ConverterServiceProvider;


import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import eu.freakydirac.ConverterServiceProvider.spi.Converter;

public class ConverterService
{
    // singleton
    private static ConverterService service;
    // service loader
    private ServiceLoader<Converter> loader;

    private ConverterService() {
        loader = ServiceLoader.load(Converter.class);
    }

    public static synchronized ConverterService getInstance() {
        if (service == null) service = new ConverterService();
        return service;
    }

    public String convert(String key) {
        String definition = null;
        try {
            Iterator<Converter> dictionaries = loader.iterator();
            while (definition == null && dictionaries.hasNext()) {
                Converter d = dictionaries.next();
                definition = d.convert(key);
            }
        } catch (ServiceConfigurationError serviceError) {
            definition = null;
            serviceError.printStackTrace();
        }
        return definition;
    }
}

