package DGP.CJLU.Experiment3.Lab3;

import DGP.CJLU.Utils.Implementation.Exceptions.FormatException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;

/**
 *Write a program to get a file's content, and check the content for the following balancing symbols: (), [], {}, Requirement:
 *  a)use customized class MyStack.
 *  b)use java.util.Stack
 *  c)In the test file,there must be English letters and symbols.
 */
public class Main {
    public static void main(String[] args) {

    }

    public StringBuilder readFileToStringBuffer(File file) {
        StringBuilder sb = new StringBuilder();
        Reader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            };
        }
        return sb;
    }

    public boolean verifyUsingStack(StringBuilder sb) throws FormatException {
        Stack<Character> stack=new Stack<>();
        String s = sb.toString();
        try{
            for(int i = 0; i < s.length(); i++){
                char c=s.charAt(i);
                if(c=='('||c=='['||c=='{')
                    stack.push(c);
                if(c==')'&&stack.pop()!='(')
                    throw new FormatException("Not Matched");
                if(c==']'&&stack.pop()!='[')
                    throw new FormatException("Not Matched");
                if(c=='}'&&stack.pop()!='{')
                    throw new FormatException("Not Matched");
                //special code for comment mark
                //replace comment mark with dollar mark
                if(c=='/'&&s.charAt(i+1)=='*')// /*
                    stack.push('$');
                if(c=='*'&&s.charAt(i+1)=='/'&&stack.pop()!='$')// */
                    throw new FormatException("Not Matched");
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }


}
