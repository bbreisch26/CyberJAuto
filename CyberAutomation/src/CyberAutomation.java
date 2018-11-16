import java.lang.Runtime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class CyberAutomation {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scan = new Scanner(System.in);
		int selection = 0;
		while (selection != -1) {
			System.out.println("CYBERPATRIOT AUTOMATION");
			System.out.println("Enter 0 to exit \n"
					+ "Enter 1 to add user \n"
					+ "Enter 2 to del user \n "
					+ "Enter 3 to turn on firewall\n"
					+ "Enter 4 to get a list of running services\n"
					+ "Enter 5 to remove a package\n"
					+ "Enter 6 to get a list of users\n");
			selection = scan.nextInt();
			switch (selection) {
			case 1:
				adduser();
				break;
			case 2:
				deluser();
				break;
			case 3:
				firewall();
				break;
			case 4:
				service();
				break;
			case 5:
				rmpackage();
				break;
			case 6:
				listusers();
			default:
				System.exit(0);
			}
		}
		
		
		
	}
	public static void adduser() throws IOException {
		Scanner scan = new Scanner(System.in);
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
		proc = Runtime.getRuntime().exec("java -jar CyberAuto.jar");
		
	}
	public static void deluser() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a username");
		String linedel = "";
		linedel = scan.nextLine();
		String commanddel = "deluser " + linedel;
		Process proc = Runtime.getRuntime().exec(commanddel);
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}
	}
	public static void firewall() throws IOException{
		String commandufw = "apt install ufw";
		Process procufw = Runtime.getRuntime().exec(commandufw);
		BufferedReader reader = new BufferedReader(new InputStreamReader(procufw.getInputStream()));
		String line = "";
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
	}
	public static void service() throws IOException {
		String commandserv = "service --status-all ";
		Process procserv = Runtime.getRuntime().exec(commandserv);
		BufferedReader reader = new BufferedReader(new InputStreamReader(procserv.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}
	}
	public static void rmpackage() throws IOException {
		String packagerm;
		Scanner scan = new Scanner(System.in);
		System.out.println("What package would you like to remove?");
		packagerm = scan.nextLine();
		String commanddel = "apt-get --yes remove " + packagerm;
		Process procdel = Runtime.getRuntime().exec(commanddel);
		BufferedReader reader = new BufferedReader(new InputStreamReader(procdel.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}
	}
	public static void listusers() throws IOException {
		String listuser;
		Scanner scan = new Scanner(System.in);
		listuser = "cut -d: -f1 /etc/passwd";
		Process listusr = Runtime.getRuntime().exec(listuser);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(listusr.getInputStream()));
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}
	}

}
