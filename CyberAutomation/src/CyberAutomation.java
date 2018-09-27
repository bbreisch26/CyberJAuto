import java.lang.Runtime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CyberAutomation {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("CYBERPATRIOT AUTOMATION");
		System.out.println("Enter 1 to add user \n Enter 2 to del user \n Enter 3 to turn on firewall");
		int selection = scan.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Enter a username");
			String line = "";
			line = scan.nextLine();
			String command = "adduser " + line;
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			line = "";
			while ((line = reader.readLine()) != null) {
				System.out.print(line + "\n");
			}
			break;
		case 2:
			System.out.println("Enter a username");
			String linedel = "";
			linedel = scan.nextLine();
			String commanddel = "deluser " + linedel;
			proc = Runtime.getRuntime().exec(commanddel);
			reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			line = "";
			while ((line = reader.readLine()) != null) {
				System.out.print(line + "\n");
			}
			break;
		case 3:
			String commandufw = "apt install ufw";
			Process procufw = Runtime.getRuntime().exec(commandufw);
			reader = new BufferedReader(new InputStreamReader(procufw.getInputStream()));
			line = "";
			while ((line = reader.readLine()) != null) {
				System.out.print(line + "\n");
			}
			commandufw = "ufw enable";
			procufw = Runtime.getRuntime().exec(commandufw);
			line = "";
			while ((line = reader.readLine()) != null) {
				System.out.print(line + "\n");
			}
			commandufw = "ufw status";
			procufw = Runtime.getRuntime().exec(commandufw);
			line = "";
			while ((line = reader.readLine()) != null) {
				System.out.print(line + "\n");
			}
			break;
		default:
			System.exit(0);
		}
		
	}

}
