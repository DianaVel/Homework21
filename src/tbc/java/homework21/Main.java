package tbc.java.homework21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    @SuppressWarnings({"deprecation","rawtypes", "unchecked"})
    public static void main(String[] args) throws ValidateException, IOException {
        Figure fig1 = new Circle(30);
        double res = Circle.getLengthStatic(fig1);
        System.out.println(res);

        ArrayList  arr = new ArrayList();
        readRectangle(new File((System.getProperty("user.dir")+"\\Rectangles-in.dat")), arr);
        System.out.println(arr);
        try {
            List<Figure> figs1 = arr;
            bugMethod(figs1);
        }catch (ClassCastException exp){
            System.out.println(exp.getMessage());
        }

        corrMethod(arr);
    }

    private static void readRectangle(File rects, ArrayList<Rectangle> rectArr) throws IOException, ValidateException {
        Scanner scanner = new Scanner(rects);
        double w,h ;
        String str;
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            Pattern pt = Pattern.compile(".+-.+");
            Matcher mt = pt.matcher(str);
            if(mt.matches()) {
                w = Double.parseDouble(str.substring(0, str.indexOf('-')));
                h = Double.parseDouble(str.substring(str.indexOf('-') + 1));
                rectArr.add(new Rectangle(w, h));
            }
        }
    }

    // Exercise - 6
    private static void bugMethod(List<Figure>... lists){
      Object [] obj = lists;
      List <Integer> l = new ArrayList<Integer>();
      l.add(50);
      obj[0] = l;
        for (List <Figure> list :lists ){
            for(Figure fig: list){
               System.out.println(fig.toString());
            }
        }
    }

    // Exercise - 7
    @SafeVarargs
    private static void corrMethod(List<Figure>... lists){
        for (List <Figure> list :lists ){
            for(Figure fig: list){
                System.out.println(fig.toString());
            }
        }
    }
}
