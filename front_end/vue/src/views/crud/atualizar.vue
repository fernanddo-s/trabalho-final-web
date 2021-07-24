<template>
  <div>
    <input v-model="message" placeholder="atualizar " />
    <p>A mensagem é: {{ message }}</p>

    <button @click="sendRequest()">Incluir</button>
  </div>
</template>

<script>
import HTTP from "@/views/services/HTTP";
export default {
  data() {
    return {
      produtos: "",
      message: "",
    };
  },

  methods: {
    sendRequest() {
      HTTP.listaDeLivro()
        .then((resposta) => {
          this.produtos = resposta.data;
          console.log(this.produtos);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>
