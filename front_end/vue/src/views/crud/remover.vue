<template>
  <div>
    <CInput
      v-model="idParaRemoao"
      placeholder="Digite o ID do livro que você deseja remover"
    />

    <button @click="sendRequest()" type="button" class="btn btn-danger">
      Remover
    </button>
  </div>
</template>

<script>
import HTTP from "@/views/services/HTTP";

export default {
  data() {
    return {
      idParaRemoao: "",
    };
  },
  mounted: {
    sendRequest() {
      HTTP.remover(this.idParaRemoao);
    },
  },
};
</script>
