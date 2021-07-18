<template>
  <div>
    <input v-model="message" placeholder="Me edite" />
    <p>A mensagem é: {{ message }}</p>

    <button @click="sendInclud()">Incluir</button>
  </div>
</template>

<script>
export default {
  mounted: {
    sendInclud() {
      // aqui vai ser a função de enviar
    },
  },
};
</script>
