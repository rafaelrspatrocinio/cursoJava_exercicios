package app;

import entities.ContratoPorHora;
import entities.Departamento;
import entities.Nivel;
import entities.Trabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento");

        String nomeDoDepartamento = sc.next();

        System.out.println("Entre com os dados do trabalhor");
        System.out.print("Nome do Trabalhador");

        String nomeDoTrabalhador = sc.next();

        System.out.print("Nivel do Trabalhador");

        String nivelDoTrabalhador = sc.next();

        System.out.print("Salario Base do Trabalhador");

        Double salarioBase = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeDoTrabalhador, Nivel.valueOf(nivelDoTrabalhador), salarioBase, new Departamento(nomeDoDepartamento));

        System.out.print("Qual o numero de contratos desse trabalhador? ");

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Entre com o data do contrato " + i);
            System.out.print("Data:(DD/MM/AAAA) ");

            Date dataContrato = sdf.parse(sc.next());

            System.out.print("Valor por hora: ");

            Double valorPorHora = sc.nextDouble();

            System.out.print("Duração do contrato em horas: ");

            int horas = sc.nextInt();

            ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorPorHora, horas);

            trabalhador.addContrato(contrato);
        }

        System.out.println();
        System.out.print("Entre com mês e ano para calcular o salario (MM/AAAA)");

        String mesEAno = sc.next();

        int mes = Integer.parseInt(mesEAno.substring(0,2));
        int ano = Integer.parseInt(mesEAno.substring(3));

        System.out.println("Nome " + trabalhador.getNome());
        System.out.println("Departamento " + trabalhador.getDepartamento().getNome());
        System.out.println("A renda para " + mesEAno + " foi de " + String.format("%.2f", trabalhador.income(ano, mes)));


        sc.close();
    }

}
