package Calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AbsMine.Steklo;
import AbsMine.Tsvet;
import AbsMine.Material;
import AbsMine.VarStvor;
import PDF.CreatePDF;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //связывание сервлета с URL
public class Calc extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String StekloGet;
	public static String StekloGetPrice;
	public static String MaterialGet;
	public static String MatsGetPrice;
	public static String TsvetGet;
	public static String TsvetaGetPrice;
	public static String AGet;
	public static String StvorGet;
	public static String BGetPrice;
	public static String check1Get;
	public static String Summa;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loginUSER") == "user") {
			RequestCalc Calc = RequestCalc.fromRequestParameters(request);
			Calc.setAsRequestAttributesAndCalculate(request);
			CreatePDF PDF = new CreatePDF();
			String goals = "Hello";
			PDF.Create(goals);
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/NotAuth.jsp").forward(request, response);
		}
	}
	private static class RequestCalc {
		private final String SteckloPack;
		private final String Mats;
		private final String Tsveta;
		private final String a;
		private final String b;
		private final String check1;
		private final String Stvorki;
		private String result;
		private double result1;
		private String steklo1;
		private String stvor1;
		private String material1;
		private String tsvet1;
		
		private RequestCalc (String priceKarkas, 
				String priceObivka, String priceNapolnitel,String NumberChair, String priceForOneChair,String check,String VidStula) {
			this.SteckloPack = priceKarkas;
			this.Mats = priceObivka;
			this.Tsveta = priceNapolnitel;
			this.a = NumberChair;
			this.b = priceForOneChair;
			this.Stvorki = VidStula;
			if (check == null) {
				check1 = "Нет";
			} else {
				check1 = "Да";
			}
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("priceKarkas"),
			request.getParameter("priceObivka"),
			request.getParameter("priceNapolnitel"),
			request.getParameter("NumberChair"),
			request.getParameter("priceForOneChair"),
			request.getParameter("check"),
			request.getParameter("VidStula"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", SteckloPack);
			request.setAttribute("second_result", Mats);
			request.setAttribute("third_result", Tsveta);
			request.setAttribute("four_result", a);
			request.setAttribute("five_result", b);
			request.setAttribute("checked", check1);
			
			String num[] = new String[20];
			try {
	            File file = new File("program1.txt");
				 if(file.exists()){				 
	            BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
	            for (int i = 0; i < 20; i++) {
	            	num[i] = br.readLine();
	            }
				 }
		 }
	        catch (Exception e) {
	            System.err.println(e.getMessage());
}
			VarStvor OneStvor = new VarStvor(); OneStvor.setPrice(num[0]); OneStvor.setName("Одностворчатое");
			VarStvor TwoStvor = new VarStvor(); TwoStvor.setPrice(num[1]); TwoStvor.setName("Двухстворчатое");
			VarStvor ThreeStvor = new VarStvor(); ThreeStvor.setPrice(num[2]); ThreeStvor.setName("Трехстворчатое");
			VarStvor TwoWithOneStvor = new VarStvor(); TwoWithOneStvor.setPrice(num[3]); TwoWithOneStvor.setName("Двухстворчатое с фрамугой");
			VarStvor ThreeWithOneStvor = new VarStvor(); ThreeWithOneStvor.setPrice(num[4]); ThreeWithOneStvor.setName("Трехстворчатое с фрамугой");
			if (Stvorki.equals(OneStvor.getPrice())) { stvor1 = OneStvor.getName();}
			if (Stvorki.equals(TwoStvor.getPrice())) { stvor1 = TwoStvor.getName();}
			if (Stvorki.equals(ThreeStvor.getPrice())) { stvor1 = ThreeStvor.getName();}
			if (Stvorki.equals(TwoWithOneStvor.getPrice())) { stvor1 = TwoWithOneStvor.getName();}
			if (Stvorki.equals(ThreeWithOneStvor.getPrice())) { stvor1 = ThreeWithOneStvor.getName();}
			
			Steklo OneStek = new Steklo(); OneStek.setPrice(num[5]); OneStek.setName("Однокамерный");
			Steklo TwoStek = new Steklo(); TwoStek.setPrice(num[6]); TwoStek.setName("Двухкамерный");
			Steklo ThreeStek = new Steklo(); ThreeStek.setPrice(num[7]); ThreeStek.setName("Трехкамерный");
			if (SteckloPack.equals(OneStek.getPrice())) { steklo1 = OneStek.getName();}
			if (SteckloPack.equals(TwoStek.getPrice())) { steklo1 = TwoStek.getName();}
			if (SteckloPack.equals(ThreeStek.getPrice())) { steklo1 = ThreeStek.getName();}
			
			
			Material Derevo = new Material();Derevo.setPrice(num[8]); Derevo.setName("Дерево");
			Material Metall = new Material();Metall.setPrice(num[9]); Metall.setName("Металл");
			Material PVH = new Material();PVH.setPrice(num[10]); PVH.setName("ПФХ");
			Material DerevoMetall = new Material();DerevoMetall.setPrice(num[11]); DerevoMetall.setName("Дерево-металл");
			Material PVHmetall = new Material();PVHmetall.setPrice(num[12]); PVHmetall.setName("ПВХ-металл");
			if (Mats.equals(Derevo.getPrice())) { material1 = Derevo.getName();}
			if (Mats.equals(Metall.getPrice())) { material1 = Metall.getName();}
			if (Mats.equals(PVH.getPrice())) { material1 = PVH.getName();}
			if (Mats.equals(DerevoMetall.getPrice())) { material1 = DerevoMetall.getName();}
			if (Mats.equals(PVHmetall.getPrice())) { material1 = PVHmetall.getName();}
			
			Tsvet Cherniy = new Tsvet();Cherniy.setPrice(num[13]); Cherniy.setName("Черный");
			Tsvet Beliy = new Tsvet();Beliy.setPrice(num[14]); Beliy.setName("Белый");
			Tsvet Cvetnoi = new Tsvet();Cvetnoi.setPrice(num[15]); Cvetnoi.setName("Цветной");
			if (Tsveta.equals(Cherniy.getPrice())) { tsvet1 = Cherniy.getName();}
			if (Tsveta.equals(Beliy.getPrice())) { tsvet1 = Beliy.getName();}
			if (Tsveta.equals(Cvetnoi.getPrice())) { tsvet1 = Cvetnoi.getName();}
			
			request.setAttribute("steklo_result", steklo1);
			request.setAttribute("stvor_result", stvor1);
			request.setAttribute("material_result", material1);
			request.setAttribute("tsvet_result", tsvet1);
			
			
			double ParSteklo=0;
			double PatMat=0;
			double ParTsvet=0;
			double ParA=0;
			double ParB=0;
			double Par=0;
			try {
				ParSteklo=Double.parseDouble(SteckloPack);
				PatMat=Double.parseDouble(Mats);
				ParTsvet=Double.parseDouble(Tsveta);
				ParA=Double.parseDouble(a);
				ParB=Double.parseDouble(b);
			}
			catch (Exception e) {
				ParSteklo = 0;
				PatMat = 0;
				ParTsvet = 0;
				ParA = 0;
				ParB = 0;
			}
				Par = PatMat+ParTsvet+ParSteklo;
			result1=Par*(ParB*ParA/100);
			result = "" + result1;
			request.setAttribute("result", result);
			
			StekloGet=steklo1;
			StekloGetPrice=SteckloPack;
			MatsGetPrice=Mats;
			MaterialGet=material1;
			TsvetGet=tsvet1;
			TsvetaGetPrice=Tsveta;
			AGet=a;
			BGetPrice=b;
			StvorGet=stvor1;
			check1Get=check1;
			Summa=result;
		}
		
	}
}