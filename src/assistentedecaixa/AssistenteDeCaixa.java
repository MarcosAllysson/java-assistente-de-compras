/*Assistente de Caixa de Loja:
Escreva um programa que simule uma caixa registradora de uma loja. O programa deve
permitir:
-- Um usuário inserir o preço de diversos produtos (que estão sendo passados no
caixa). 
-- O programa deve somar os valores dos preços digitados. 
-- Após passar todos os preços (terminou de passar os produtos), o sistema deve indicar o TOTAL e então perguntar
qual a forma de pagamento: 
-- Dinheiro, cheque ou cartão de crédito. 
-- Se a opção for por o cartão de crédito, o sistema deve permitir o parcelamento em até 10 vezes, apresentando o
valor da parcela. 
-- Se a opção for o cheque o sistema deve permitir ao usuário escolher entre
o parcelamento em até 3 vezes, apresentando o valor da parcela.
-- Permitir o pagamento em parcela única com 5% de desconto (apresentando o valor com desconto). 

-- Se a opção for por dinheiro, deve dar um desconto de 10% (apresentar o novo valor), solicitar valor
entregue pelo usuário e calcular o troco que o usuário deve receber. */
package assistentedecaixa;

import javax.swing.JOptionPane;

public class AssistenteDeCaixa {

    public static void main(String[] args) {
        float valorProdutos;
        float soma=0;
        String produtos;
        
        do {
            produtos = JOptionPane.showInputDialog("Caixa: \n\n Insira valor do produto: "
                    + "\n\n Para ver soma total, basta digitar 0 \n\n");
            valorProdutos = Float.parseFloat(produtos);
            soma += valorProdutos;
        } while (valorProdutos != 0);
        
        String opcao = JOptionPane.showInputDialog(null,"Valor total: R$" +soma+ 
                ". \n Qual forma de pagamento? \n\n (1) Cartão de Crédito; \n (2) Cheque; \n (3) Dinheiro.");
        int opcaoSelecionada = Integer.parseInt(opcao); 
        
        if (opcaoSelecionada == 1){
            int parcelas;
            do{
                String cartaoDeCredito = JOptionPane.showInputDialog(null,"Você escolheu efetuar pagamento "
                    + "com cartão de crédito. Gostaria de dividir em quantas vezes? "
                    + "\n\n Lembrando que pode dividir em até 10x sem juros!");
                 parcelas = Integer.parseInt(cartaoDeCredito);
                float valorParcelas = soma / parcelas;
                float valorDesconto = (soma*5) /100;
                float valorNovo = soma - valorDesconto;
                if(parcelas == 1){
                JOptionPane.showMessageDialog(null,"Parabéns por querer pagar de uma vez. Com isso, você merece um desconto! \n"
                        + "Novo valor fica: R$" +valorNovo+ ". \n Continue assim! Muito obrigado e volte sempre!");
            }
            else if ((parcelas > 1) && (parcelas < 11)){
                JOptionPane.showMessageDialog(null,"Valor de cada parcela: R$" +valorParcelas+ ". \n Muito obrigado e volte sempre!");
            }             
            else {
                JOptionPane.showMessageDialog(null,"Lembre-se, somente pode dividir em até 10 vezes. Poderia tentar de novo?");
            }
            }while(parcelas > 10);
        }
        
        else if (opcaoSelecionada == 2){
            int parcelas;
            do {
            String cheque = JOptionPane.showInputDialog(null,"Você escolher efetuar pagamento com cheque. "
                    + "Gostaria de dividir em quantas vezes? \n\n Lembrando que pode dividir em até 3x.");
            parcelas = Integer.parseInt(cheque);
            float valorParcelas = soma / parcelas;
            float valorDesconto = (soma*5) /100;
            float valorNovo = soma - valorDesconto;
            if (parcelas == 1){
                JOptionPane.showMessageDialog(null,"Vejo que você é uma pessoa inteligente. Escolheu pagar de uma vez e por isso,"
                        + "merece desconto! \n Valor novo fica apenas: R$" +valorNovo+ ". \n Continue assim, muito obrigado e volte sempre!");
            }
            else if ((parcelas > 1)&&(parcelas < 4)){
                JOptionPane.showMessageDialog(null,"Valor de cada parcela: R$" +valorParcelas+ ". \n Muito obrigado e volte sempre!");
            } else {
                JOptionPane.showMessageDialog(null,"Lembre-se, somente pode dividir em até 3 vezes. Poderia tentar novamente");
            }
            } while (parcelas >= 4);         
        } 
        
        else if (opcaoSelecionada == 3){            
            float dinheiroRecebido; 
            String valorDinheiro;
            float valorDesconto = (soma*10)/100;
            float valorNovo = soma - valorDesconto;
                        
            JOptionPane.showMessageDialog(null,"Eita, cliente especial. Merece um belo desconto, que tal 10%? "
                    + "\n Valor novo fica apenas: R$"+valorNovo); 
            valorDinheiro = JOptionPane.showInputDialog(null,"ATENDENTE: Gostaria de algo mais? \n "
                            + "EU: Não, só isso mesmo! Aqui o dinheiro: ");
            dinheiroRecebido = Float.parseFloat(valorDinheiro);
                        
            if (dinheiroRecebido >= valorNovo){
                float trocoCliente = dinheiroRecebido - valorNovo;
                JOptionPane.showMessageDialog(null,"ATENDENTE: Seu troco R$"+trocoCliente+ ". \n Muito obrigado e volte sempre!");
                JOptionPane.showMessageDialog(null,"EU: Igualmente!");
            }
            else if (dinheiroRecebido < valorNovo){
                float quantoFalta = valorNovo - dinheiroRecebido;
                JOptionPane.showMessageDialog(null,"ATENDENTE: Desculpe-me senhor. Ainda faltam R$ "+quantoFalta+ " para finalizarmos a compra."
                        + "Verifique se o senhor tem este valor.");
                JOptionPane.showMessageDialog(null,"EU: Opa, foi mal. Aqui esta!");
                JOptionPane.showMessageDialog(null,"ATENDENTE: Muito obrigado! Se não quiser as moedinhas, pode deixar comigo ;) !");
                JOptionPane.showMessageDialog(null,"Quem sabe na próxima! \n Até mais.");
            } 
        }
        else {
            JOptionPane.showMessageDialog(null,"Opção inválida. Por favor, verifique novamente e tente mais tarde! Agradeço.");
        }      
    }
}
