<template>
  <div>
    <CRow>
      <CCol sm="12">
        <CInput
          v-model="atualizarAutor"
          placeholder="Digite o ID que você quer atualizar"
        />
        <br />
        <CInput v-model="atualizarAutor" placeholder="Nome do autor" />
        <CInput v-model="atualizarLivro" placeholder="Nome do livro" />
        <CInput v-model="atualizarAno" placeholder="Ano de publicação" />
      </CCol>
    </CRow>

    <button @click="sendRequest()" type="button" class="btn btn-primary">
      Adicionar
    </button>
  </div>
</template>

<script>
import HTTP from "@/views/services/HTTP";
export default {
  data() {
    return {
      id: "",
      atualizarAutor: "",
      atualizarLivro: "",
      atualizarAno: "",
    };
  },

  methods: {
    sendRequest() {
      HTTP.incluir(this.atualizarAno, this.atualizarAutor, this.atualizarLivro);
    },
  },
};
</script>
