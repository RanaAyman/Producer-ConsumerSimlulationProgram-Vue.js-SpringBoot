<template>
  <div id = "full">
    <br>
    <div>
    <h2 style="text-align:center;"><i class="fas fa-industry"></i> Producer/Consumer Simulation</h2>
    </div>
    <div  id = "app">
    <section v-if="demo === 'default'">
      <DiagramEditor v-model="graph"></DiagramEditor>
    </section>
    </div>
  </div>
</template>

<script>
import { DiagramEditor } from "../index.js";
export default {
  name: "app",
  components: {
    DiagramEditor
  },
  data() {
    return {
      demo: "default",
     graph: {
        width:1350,
        height: 500,
        background: "#f0f0f0",
        nodes: [],
        links: []
      }
    };
  },
  mounted() {
    this.graph ();
  },
  methods: {
    refresh() {
      this.graph();
    }
  }
};
</script>

<style lang="scss">
  #full {
    font-family:"Comic Sans MS", cursive, sans-serif;
    // font-size:1.6em;
    height: 100vh;
    width: 100%;
    // background-image: url(cool-background.png);
    // background-position: center;
    // background-size: cover;
    // background-repeat: no-repeat;
    background-image: linear-gradient(to right top, #d16ba5, #cb80bf, #c394d3, #bba7e3, #b7b9ed, #aec4f6, #a7cffc, #a2d9ff, #8ce2ff, #76ebff, #64f4fe, #5ffbf1);
  }
  #app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    min-height: 80%;
    font-family: "Roboto", sans-serif;
    overflow: hidden;
    display: -webkit-box;
    display: flex;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    align-items: center;
    width: 100%;
    background-size: cover;
    overflow:hidden;
  }
  .scrollXY {
    overflow-x: auto;
    overflow-y: auto;
  }
  

</style>
