<template>
  <div class="cartao p-grid">
    <div class="cartao-container p-col-3">
      <div class="cartao-front">
        <div class="data-card">
          Foto do Jonas
        </div>
      </div>
      <div class="cartao-back">
        <div class="data-card">
          Jonas bezerra
          <br />
          399799
          <br />Engenharia de computação
          <br />
          9° semestre
        </div>
      </div>
    </div>

    <div class="cartao-container p-col-3">
      <div class="cartao-front">
        <div class="data-card">
          Foto do Jonas
        </div>
      </div>
      <div class="cartao-back">
        <div class="data-card">
          Jonas bezerra
          <br />
          399799
          <br />Engenharia de computação
          <br />
          9° semestre
        </div>
      </div>
    </div>

    <div class="cartao-container p-col-3">
      <div class="cartao-front">
        <div class="data-card">
          Foto do Jonas
        </div>
      </div>
      <div class="cartao-back">
        <div class="data-card">
          Jonas bezerra
          <br />
          399799
          <br />Engenharia de computação
          <br />
          9° semestre
        </div>
      </div>
    </div>

    <div class="cartao-container p-col-3">
      <div class="cartao-front">
        <div class="data-card">
          Foto do Jonas
        </div>
      </div>
      <div class="cartao-back">
        <div class="data-card">
          Jonas bezerra
          <br />
          399799
          <br />Engenharia de computação
          <br />
          9° semestre
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {},
};
</script>

<style>
.cartao {
  height: 200px;
  width: 200px;
  perspective: 1000px;
}

.cartao-container {
  position: relative;
  height: 100%;
  transition: transform 0.4s;
  transform-style: preserve-3d;
}

.cartao:hover .cartao-container {
  transform: rotateY(180deg);
}

.cartao-front,
.cartao-back {
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
  z-index: 1;
}

.cartao-front {
  background: green;
}

.cartao-back {
  transform: rotateY(180deg);
  background: red;
}

.data-card {
  font-weight: bold;
  margin-left: 5px;
}
</style>
