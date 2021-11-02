import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class App {

    interface Compression {
        public InputStream lempelziv(InputStream byteStream);
        public InputStream huffman(InputStream byteStream);
        public InputStream full(InputStream bytestream);
    }

    class Compressor implements Compression{

        @Override
        public InputStream lempelziv(InputStream byteStream) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public InputStream huffman(InputStream byteStream) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public InputStream full(InputStream bytestream) {
            // TODO Auto-generated method stub
            Objects.requireNonNull(bytestream, "Bytestream is null");
            return null;
        }

    }

    class Decompressor implements Compression{

        @Override
        public InputStream lempelziv(InputStream byteStream) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public InputStream huffman(InputStream byteStream) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public InputStream full(InputStream bytestream) {
            // TODO Auto-generated method stub
            Objects.requireNonNull(bytestream, "Bytestream is null");
            return null;
        }

    }

    public void compress(InputStream byteStream) {
        new Compressor().full(byteStream);
    }

    public void decompress(InputStream byteStream) {
        new Decompressor().full(byteStream);
    }

    enum Argument {
        NONE,
        COMPRESS,
        DECOMPRESS
    }

    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.printf("Define either '-c' for compression, or '-d' for decompression"
            + " as first argument. \nDefine filepath as second argument.\n");
            System.out.println("E.g: -c <filepath>");
            return;
        };

        App app = new App();

        Argument arg = Argument.NONE;
        if (args[0].equals("-c")) {
            arg = Argument.COMPRESS;
        } else if (args[0].equals("-d")) {
            arg = Argument.DECOMPRESS;
        }

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(new File(args[1]));
            // read one byte at a time
            Files.copy(stream, Paths.get("output.pdf"), StandardCopyOption.REPLACE_EXISTING);
            // close the reader
            stream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        switch(arg) {
            case COMPRESS:
                System.out.println("-c");
                app.compress(stream);
                break;
            case DECOMPRESS:
                System.out.println("-d");
                app.decompress(stream);
                break;
            default:
                System.out.println("Default switch called");
                break;
        }

        return;
    }
}