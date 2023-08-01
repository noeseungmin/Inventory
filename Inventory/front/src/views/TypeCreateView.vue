<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { useRouter } from "vue-router";

const itemType = ref([]);

import axios from "axios";
const router = useRouter()

const typeCode= ref("")
const name= ref("")


const typeCreate = function (){
  axios.post("/api/items/type", {
    typeCode: typeCode.value,
    name: name.value
  })
      .then(() => {
        router.replace({ name: "write" });
      });
};

const formLabelAlign = reactive({
  name: '',
  region: '',
  type: '',
})
</script>

<template>
  <el-form label-width="100px"
           :model="formLabelAlign"
           style="max-width: 460px"
  >
    <el-form-item label="타입 코드">
      <el-input v-model="typeCode" />
    </el-form-item>
    <el-form-item label="제품 타입">
      <el-input v-model="name" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="typeCreate()">
        등록
      </el-button>
      <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
    </el-form-item>
  </el-form>
</template>