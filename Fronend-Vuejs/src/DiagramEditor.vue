<template>
  <div id="editor">
    <div>
    <VButton class="btn btn2" v-if="!editable" @click="editable = true"><i class="fas fa-edit"></i> &nbsp;Edit</VButton>
    <span v-else>
      <VButton class="btn btn2" @click="openModal">New Node</VButton>
    </span>
    <VButton class="btn btn2" @click="openInputModal"><i class="fas fa-file-import"></i>  &nbsp;Import/Export</VButton>
    <VButton class="btn btn2" @click="downloadSVG"><i class="fas fa-download"></i>  &nbsp; Download SVG</VButton>
    <VButton class="btn btn2" @click="isAskClearDiagram = true"><i class="fas fa-trash-alt"></i>  &nbsp;Clear Diagram</VButton>
    <VButton class="btn btn2" @click="openSettingsModal"><i class="fas fa-cogs"></i>  &nbsp;Settings</VButton>
    <VButton class="btn btn2" @click="start"><i class="fas fa-play-circle"></i>  &nbsp;Start</VButton>
    <VButton class="btn btn2" @click="end"><i class="fas fa-stop"></i> &nbsp; End</VButton>
    &nbsp;
    &nbsp;
    //<p>test</p>
    <i class="fas fa-sitemap"></i>
    &nbsp;
    <VInput class="vinput"
          type="number"
          v-model="numberOfProducts"
          placeholder="Number Of Products"
        />
        </div>
    <AskModal :isActive="isAskClearDiagram" @ok="clearDiagram" @cancel="cancel">
      Do you wanna clear the Diagram?
    </AskModal>
    <EditNodeModal
      :node="{ content: {} }"
      :isActive="isModalActive"
      @ok="addNode"
      @cancel="cancel"
    />
    <EditNodeModal
      :node="tmpNode"
      :isActive="isEditModalActive"
      @ok="editNode"
      @cancel="cancel"
    />
    <EditLinkModal
      :link="tmpLink"
      :isActive="isEditLinkModalActive"
      @ok="editLink"
      @cancel="cancel"
    />
    <InputModal
      :text="json"
      :isActive="isInputModalActive"
      @ok="importData"
      @cancel="cancel"
    />
    <SettingsModal
      :isActive="isSettingsModalActive"
      :settings="settings"
      @ok="updateSettings"
      @cancel="cancel"
    />
    <Diagram
      :width="graphData.width || 2000"
      :height="graphData.height || 1000"
      :fluid="settings.isFluid"
      :scale="settings.scale"
      :background="graphData.background || '#fafafa'"
      :showGrid="graphData.showGrid"
      :nodes="graphData.nodes"
      :links="graphData.links"
      :editable="editable"
      :labels="
        graphData.labels || {
          edit: 'Edit',
          remove: 'Remove',
          link: 'New Link',
          select: 'Select',
          cancel: 'Cancel',
          copy: 'Copy'
        }
      "
      @editNode="openNodeEdit"
      @editLink="openLinkEdit"
      @nodeClicked="nodeClicked"
      @linkClicked="linkClicked"
      @nodeChanged="nodeChanged"
      @linkChanged="linkChanged"
      @nodeRemoved="nodeRemoved"
      @linkRemoved="linkRemoved"
    >
    </Diagram>
  </div>
</template>

<script>
import axios from 'axios'
import Diagram from "./Diagram";
import EditNodeModal from "@/lib/EditNodeModal";
import EditLinkModal from "@/lib/EditLinkModal";
import InputModal from "@/lib/InputModal";
import AskModal from "@/lib/AskModal";
import SettingsModal from "@/lib/SettingsModal";
import VInput from "@/minimal-ui/lib/VInput";
export default {
  name: "DiagramEditor",
  components: {
    Diagram,
    EditNodeModal,
    EditLinkModal,
    InputModal,
    AskModal,
    SettingsModal
  },
  props: {
    value: {
      type: Object,
      default: () => {
        return {
          width: 2000,
          height: 1000,
          background: "#fafafa",
          showGrid: false,
          labels: {
            edit: "Edit",
            remove: "Remove",
            link: "New Link",
            select: "Select",
            copy: "Copy"
          },
          nodes: [],
          links: [],
        };
      }
    }
  },
  computed: {
    graphData: {
      get() {
        return this.value;
      },
      set(val) {
        this.$emit("input", val);
      }
    },
  },
  data() {
    return {
      name: "",
      url: "",
      color: "",
      json: "",
      isModalActive: false,
      isEditModalActive: false,
      isEditLinkModalActive: false,
      isInputModalActive: false,
      isSettingsModalActive: false,
      editable: false,
      settings: {
        width: 1500,
        height: 1000,
        isFluid: false,
        scale: "1",
        showGrid: false
      },
      tmpNode: {
        id: "",
        shape: "rectangle",
        width: 0,
        height: 0,
        content: {
          text: "",
          url: "",
          color: ""
        }
      },
      tmpLink: {
        id: "",
        content: {
          color: "",
          pattern: "solid",
          arrow: "none"
        },
      shapes:[],
      tempShapes:[],
      shapesLinks:[]
      },
      isAskClearDiagram: false,
      colors:["red","blue","green","yellow"],
      flag:false,
      numberOfProducts:'',
      arr:[],
      firstTime:true,
    };
  },
  mounted(){
  },
  created() {
    this.interval = setInterval(() => this.changeColors(), 200);
},
  methods: {
    end(){
      this.flag = false;
      },
    start(){
      if(this.numberOfProducts == ''){
        alert("Please Enter the numbers of products !")
      }else{
      this.editable = false;
      this.flag = true;
      var arrayofIDs= [];
      var arrayofShapes = [];
      for(var i = 0; i < this.graphData.nodes.length; i++){
        arrayofIDs[i] = this.graphData.nodes[i].id;
        arrayofShapes[i] = this.graphData.nodes[i].shape;
      }
      var source = [];
      var dest = [];
      for(var i = 0; i < this.graphData.links.length; i++){
        source[i] = this.graphData.links[i].source;
        dest[i] = this.graphData.links[i].destination;
      }
      if(this.firstTime){
        axios.get("http://localhost:8085/api/start", {params:{shapesID: arrayofIDs + '', shapesSh: arrayofShapes + '', arrowsSrc: source + '', arrowsDst: dest + '', productsNum: this.numberOfProducts}}).then(res => console.log(res));
         this.firstTime = false;
      } else {
        axios.get("http://localhost:8085/api/repeat", {params:{shapesID: arrayofIDs + '', shapesSh: arrayofShapes + '', arrowsSrc: source + '', arrowsDst: dest + '', productsNum: this.numberOfProducts}}).then(res => console.log(res));
       }
      }
      
      // console.log( arrayofIDs);
      // console.log( arrayofShapes);
      // console.log( source);
      // console.log( dest);
    },
    async changeColors(){
      if(this.flag){
        await axios.get("http://localhost:8085/api/update").then(res => this.arr = res.data);
        for(var i = 0; i < this.arr.length; i++){
          let tmp = this.graphData.nodes.find(x => x.id == this.arr[i].id);
          console.log(this.arr[i].color);
          tmp.content.color = this.arr[i].color;
        }        
      }
    },
    clearDiagram() {
      this.graphData.nodes = [];
      this.graphData.links = [];
      this.isAskClearDiagram = false;
    },
    generateID() {
      return (
        new Date().getTime().toString(16) +
        Math.floor(Math.random() * 1000000).toString(16)
      );
    },
    openModal() {
      this.isModalActive = true;
    },
    cancel() {
      this.isModalActive = false;
      this.isEditModalActive = false;
      this.isEditLinkModalActive = false;
      this.isInputModalActive = false;
      this.isAskClearDiagram = false;
      this.isSettingsModalActive = false;
    },
    addNode(item) {
      this.graphData.nodes.push({
        id: this.generateID(),
        content: {
          text: item.content.text,
          url: item.content.url,
          color: item.content.color,
        },
        width: parseInt(item.width) || 150,
        height: parseInt(item.height) || 60,
        stroke: item.stroke,
        strokeWeight: item.strokeWeight,
        shape: item.shape,
        point: {
          x: 10,
          y: 100 + Math.random() * 100
        }
      });
      this.isModalActive = false;
    },
    openNodeEdit(item) {
      this.tmpNode.id = item.id;
      this.tmpNode.content.text = item.content.text;
      this.tmpNode.content.url = item.content.url;
      this.tmpNode.content.color = item.content.color;
      this.tmpNode.shape = item.shape;
      this.tmpNode.stroke = item.stroke;
      this.tmpNode.strokeWeight = item.strokeWeight;
      this.tmpNode.width = item.width;
      this.tmpNode.height = item.height;
      this.isModalActive = false;
      this.isEditModalActive = true;
    },
    editNode(item) {
      let tmp = this.graphData.nodes.find(x => x.id === item.id);
      tmp.content.text = item.content.text;
      tmp.content.url = item.content.url;
      tmp.content.color = item.content.color;
      tmp.shape = item.shape; 
      tmp.stroke = item.stroke;
      tmp.strokeWeight = item.strokeWeight;
      tmp.width = parseInt(item.width);
      tmp.height = parseInt(item.height);
      this.isEditModalActive = false;
    },
    openLinkEdit(item) {
      this.tmpLink.id = item.id;
      this.tmpLink.content = Object.assign({}, item.content);
      this.isEditLinkModalActive = true;
    },
    editLink(item) {
      let tmp = this.graphData.links.find(x => x.id === item.id);
      tmp.color = item.content.color;
      tmp.shape = item.content.shape;
      tmp.pattern = item.content.pattern;
      tmp.arrow = item.content.arrow;
      this.isEditLinkModalActive = false;
    },
    endEdit() {
      this.editable = false;
    },
    nodeClicked(id) {
      console.log(id);
    },
    linkClicked(id) {
      this.$emit("linkClicked", id);
    },
    nodeRemoved(id) {
      this.$emit("nodeRemoved", id)
    },
    linkRemoved(id) {
      this.$emit("linkRemoved", id)
    },
    nodeChanged(obj) {
      this.graphData.nodes = obj.nodes;
    },
    linkChanged(obj) {
      this.graphData.links = obj.links;
    },
    openInputModal() {
      this.isInputModalActive = true;
      this.json = JSON.stringify(this.graphData);
    },
    importData(value) {
      const obj = JSON.parse(value.text);
      if (obj) {
        this.graphData = obj;
        this.isInputModalActive = false;
      }
    },
    downloadSVG() {
      const blob = new Blob(
        [document.getElementById("svg-diagram-show-area").innerHTML],
        {
          type: "image/svg+xml"
        }
      );
      const url = window.URL.createObjectURL(blob);
      const link = document.createElement("a");
      link.href = url;
      link.download = "image.svg";
      link.click();
    },
    changeGrid() {
      this.graphData.width = parseInt(this.settings.width);
      this.graphData.height = parseInt(this.settings.height);
      this.graphData.showGrid = this.settings.showGrid;
    },
    openSettingsModal() {
      this.isSettingsModalActive = true;
      this.settings.width = this.graphData.width;
      this.settings.height = this.graphData.height;
      this.settings.showGrid = this.graphData.showGrid;
    },
    updateSettings(val) {
      this.settings = Object.assign({}, val);
      this.changeGrid();
      this.isSettingsModalActive = false;
    }
  }
};
</script>
<style lang="scss" scoped>
$blue: #3498db;
.btn {
  box-sizing: border-box;
  appearance: none;
  background-color: #3498db;
  border-radius: 0.6em;
  cursor: pointer;
  align-self: center;
  font-size: 0.9rem;
  font-weight: 400;
  line-height: 1;
  margin: 5px;
  padding: 1em 1em;
  text-decoration: none;
  text-align: center;
  text-transform: uppercase;
  font-family:"Comic Sans MS", cursive, sans-serif;
  font-weight: 700;

  &:hover,
  &:focus {
    color: rgb(0, 0, 0);
    outline: 0;
  }
}
.btn2 {
  border-color: $blue;
  color: rgb(0, 0, 0);
  background: {
    image: linear-gradient(45deg,$blue 50%,transparent 50%);
    position: 100%;
    size: 400%;
  }
  transition: background 300ms ease-in-out;
  
  &:hover {
    background-position: 0;
  }
}
.vinput{
color:rgb(0, 0, 0);
font-size: 1.1rem;
font-weight: 400;
border-color: $blue;
border:2px solid $blue;
border-radius: 0.6em;
width:180px;
}
</style>
