<template>
  <div>
    <CRow>
      <CCol sm="12">
        <CInput
          v-model="messageAutor"
          placeholder="Nome do autor"
          invalid-feedback="valor inválido"
        />
        <CInput v-model="messageLivro" placeholder="Nome do livro" />
        <CInput v-model="messageAno" placeholder="Ano de publicação" />
      </CCol>
    </CRow>

    <button @click="sendRequest()" type="button" class="btn btn-success">
      Adicionar
    </button>
  </div>
</template>

<script>
import HTTP from "@/views/services/HTTP";
export default {
  data() {
    return {
      produtos: "",
      messageAutor: "",
      messageLivro: "",
      messageAno: "",
    };
  },

  methods: {
    sendRequest() {
      HTTP.incluir(this.messageAno, this.messageAutor, this.messageLivro);
    },
  },
};
</script>
