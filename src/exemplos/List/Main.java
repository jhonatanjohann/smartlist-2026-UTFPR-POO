package exemplos.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Tatiane", 23, 4500),
                new Pessoa("Vitoe", 19, 1590),
                new Pessoa("Carlos", 18, 1800),
                new Pessoa("Camila", 22, 2000),
                new Pessoa("Marcela", 28, 4900),
                new Pessoa("Pedro", 21, 16000)
        );

        pessoas.stream().map(Pessoa::getNome).forEach(System.out::println); //map(pessoa -> pessoa.getNome())

        List<String> nomes = pessoas.stream().map(Pessoa::getNome).toList();


// pessoas.sort(Comparator.comparing(Pessoa::getNome));
// pessoas.forEach(p -> System.out.println(p.getNome()));
        List<String> nomesOrdenados = pessoas.stream().map(Pessoa::getNome).sorted().toList();
/*
        List<Pessoa> pessoasMaisDe20Anos= new ArrayList<>();
        for(Pessoa pessoa: pessoas){
            if (pessoa.getIdade() > 20) {
                pessoasMaisDe20Anos.add(pessoa);
            }
        }
*/
        List<Pessoa> pessoasMaisDe20Anos = pessoas.stream().filter(p -> p.getIdade() > 20).toList();

        List<Double> pessoasSalarios = pessoas.stream().map(Pessoa::getSalario).toList();
        Set<Double> pessoasSalariosSemRepeticao = pessoas.stream().map(Pessoa::getSalario).collect(Collectors.toSet());
        List<Double> pessoasSalariosDistintos = pessoas.stream().map(Pessoa::getSalario).distinct().toList();

        long nmrPessoasSalariosAcima5000 = pessoas.stream().filter(p -> p.getSalario() > 5000).count();

        double somaSalarios = pessoas.stream().map(Pessoa::getSalario).reduce(0.0, (s1, s2) -> s1 + s2);
        double somaSalarios2 = pessoas.stream().mapToDouble(Pessoa::getSalario).sum();
        double mediaSalarios = pessoas.stream().mapToDouble(Pessoa::getSalario).average().orElse(0);
        double maximoSalarios = pessoas.stream().mapToDouble(Pessoa::getSalario).max().orElse(0);
        double minimoSalarios = pessoas.stream().mapToDouble(Pessoa::getSalario).min().orElse(0);


        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
        System.out.println(nomes.toString());
        System.out.println(nomesOrdenados.toString());
        System.out.println("Salario sem repetir: " + pessoasSalariosSemRepeticao);
        System.out.println("Salario distintos: " + pessoasSalariosDistintos);
        System.out.println("Salario Acima 5000: " + nmrPessoasSalariosAcima5000);
        System.out.println("Salario: " + pessoasSalarios);
        System.out.println("Salario soma: " + somaSalarios2);
        System.out.println("Salario media: " + mediaSalarios);
        System.out.println("Salario maximo: " + maximoSalarios);
        System.out.println("Salario minimo: " + minimoSalarios);
    }
}
