package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    static List<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        // Remove this assignment of "stringArrayList".
        this.stringArrayList = new LinkedList<>(stringArrayList);
    }

    public LocalProcessor() {
    }

    // ne nujno sozdavat'
    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        for (String name : stringList) {
            System.err.println(name.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringBuilder result = new StringBuilder();
        for (String name: stringList) {
            result.append(name + " ");
        }

        processorName = result.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            informationScanner = new Scanner(file);
            StringBuilder result = new StringBuilder();

            while (informationScanner.hasNext()) {
                result.append(informationScanner.nextLine());
            }

            processorVersion = result.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            if (informationScanner != null) {
                informationScanner.close();
            }
        }
    }
}
