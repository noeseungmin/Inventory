<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { useRouter } from "vue-router";

const itemType = ref([]);

axios.get("/api/items/type").then(response => {
  response.data.data.forEach((r: any) => {
    itemType.value.push(r)
  });
});

import axios from "axios";
const router = useRouter()


const itemCode = ref("")
const name= ref("")
const typeName= ref("")
const quantity= ref("")
const price= ref("")

const itemCreate = function (){
  axios.post("/api/items", {
    itemCode: itemCode.value,
    name: name.value,
    typeName: typeName.value,
    quantity: quantity.value,
    price: price.value
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
    <el-form-item label="제품 코드">
      <el-input v-model="itemCode" />
    </el-form-item>
    <el-form-item label="제품 분류">
      <el-select v-model="typeName">
        <el-option v-for="(type, index) in itemType" :key="index" :value="type.name">{{ type.name }}</el-option>>
      </el-select>
    </el-form-item>
    <el-form-item label="제품 이름">
      <el-input v-model="name" />
    </el-form-item>
    <el-form-item label="제품 가격">
      <el-input v-model="price" />
    </el-form-item>
    <el-form-item label="제품 수량">
      <el-input v-model="quantity" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="itemCreate()">
        등록
      </el-button>
      <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
    </el-form-item>

  </el-form>
</template>


