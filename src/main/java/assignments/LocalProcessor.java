package assignments;

import java.io.File;
import java.io.FileNotFoundException;
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
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        try {
            for (String name : stringList) {
                System.out.println(name.hashCode());
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder result = new StringBuilder();

        try {
            for (String name: stringList) {
                result.append(name + " ");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (!(obj instanceof LocalProcessor)) {
            return false;
        }

        LocalProcessor lObj = (LocalProcessor) obj;
        return lObj.processorName.equals(processorName);
    }

}
