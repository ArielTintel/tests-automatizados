package automatizado.build;

import automatizado.pages.ControleProdutoPage;

public class ProdutoBuilder {

    private String codigo = "0000";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 999999.99;
    private String data = "01/01/2022";
    private final ControleProdutoPage controleProdutoPage;

    public ProdutoBuilder(ControleProdutoPage controleProdutoPage){
        this.controleProdutoPage = controleProdutoPage;
    }

    public void builder() {
        controleProdutoPage.digitar(controleProdutoPage.campoCodigoTelaCadastros, codigo);
        controleProdutoPage.digitar(controleProdutoPage.campoNomeTelaCadastros, nome);
        controleProdutoPage.digitar(controleProdutoPage.campoQuantidadeTelaCadastros, (quantidade != null) ? quantidade.toString() : "");
        controleProdutoPage.digitar(controleProdutoPage.campoValorTelaCadastros,(valor != null) ? valor.toString() : "");
        controleProdutoPage.digitar(controleProdutoPage.campoDataTelaCadastros, data);
        controleProdutoPage.botaoSalvarTelaCadastros.click();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }

}
