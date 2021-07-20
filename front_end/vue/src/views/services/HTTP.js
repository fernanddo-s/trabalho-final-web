import { http } from "./config";

export default {
  salvar: (produto) => {
    return http.post("produto", produto);
  },

  atualizar: (produto) => {
    return http.put("produto", produto);
  },

  listar: () => {
    console.log(http.get("books/test"));
    return http.get("books/test");
  },

  apagar: (produto) => {
    return http.delete("produto", { data: produto });
  },
};
