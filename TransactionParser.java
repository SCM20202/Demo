
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.io.File;
import java.util.List;

public interface TransactionParser {

    List<Transactions> parse(File transactionsFile);
}