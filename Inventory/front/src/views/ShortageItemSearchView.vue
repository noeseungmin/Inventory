<script setup lang="ts" xmlns="http://www.w3.org/1999/html">
import axios, {create} from "axios";
import {ref} from "vue";

const items = ref([]);
const itemType = ref([]);
const search = ref([]);
const typeName= ref([]);
const quantity= ref([]);

const itemCreate = function (typeName, quantity) {
  axios.get("/api/items/shortage?", {
    params: {typeName: typeName, quantity: quantity}
  })
      .then(response => {
        response.data.data.forEach((r: any) => {
          search.value.push(r)
        });
      });
};

axios.get("/api/items/type").then(response => {
  response.data.data.forEach((r: any) => {
    itemType.value.push(r)
  });
});

axios.get("/api/items").then(response => {
  response.data.data.forEach((r: any) => {
    items.value.push(r)
  });
});

</script>

<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="16">
        <el-table :data="search">
          <el-table-column prop="itemCode" label="상품코드"/>
          <el-table-column prop="typeCode" label="분류코드"/>
          <el-table-column prop="typeName" label="분류이름"/>
          <el-table-column prop="name" label="상품이름"/>
          <el-table-column prop="price" label="상품가격"/>
          <el-table-column prop="quantity" label="재고수량"/>
        </el-table>
      </el-col>
      <el-col :span="8">
        <el-row :gutter="20">
          <el-col :span="16">
            <el-form label-width="100px"
                     el-input-width="100px"
            >
              <el-form-item label="제품 분류">
                <el-select v-model="typeName">
                  <el-option v-for="(type, index) in itemType" :key="index" :value="type.name">{{ type.name }}</el-option>>
                </el-select>
              </el-form-item>
              <el-form-item label="부족 수량">
                <el-input v-model="quantity"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="8">
            <el-form-item>
              <el-button type="primary" @click="itemCreate(typeName, quantity)">
                검색
              </el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-col>
    </el-row>


  </div>
</template>