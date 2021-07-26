import { http } from "./config";

export default {
  salvar: (produto) => {
    return http.post("produto", produto);
  },

  atualizar: (produto) => {
    return http.put("produto", produto);
  },

  listar: () => {
    console.log(http.get("books/register"));
    return http.get(
      "books/test?id=asd&title=3234&Abstract=43545&Author=jdapsjd&passsword=onfna"
    );
  },

  incluir: (ano, autor, livro) => {
    var conexao =
      "books/test?autor=" + autor + "&title=" + livro + "&ano=" + ano;
    return http.get(conexao);
  },

  remover: (ano, autor, livro) => {
    var conexao =
      "books/test?autor=" + autor + "&title=" + livro + "&ano=" + ano;
    return http.get(conexao);
  },
  
  listaDeLivro: () => {
    console.log(http.get("books/list"));
    return http.get("books/list");
  },

  apagar: (produto) => {
    return http.delete("produto", { data: produto });
  },
};
