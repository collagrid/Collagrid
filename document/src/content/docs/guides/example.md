---
title: Example Guide
description: A guide in my new Starlight docs site.
---

Guides lead a user through a specific task they want to accomplish, often with a sequence of steps.
Writing a good guide requires thinking about what your users are trying to do.

## Further reading

表格数据遵循下面的数据结构

```json5
{
  dstId: 'dstxxxxxx', // dst开头的小写随机字符串，保持唯一性
  views: [ // 视图信息，多个视图就是多个数组
    {
      viewId: "viexxxxx", // view开头的小写随机字符串当做视图id
      rows: [ // 行信息，多个行就是多个数组,行的顺序就是表格显示的顺序
        {
          id: "recxxx", // 行序
          chunkId: "chuxxx", // chunkId, chu 开头
        }
      ],
      chunks: [ // chunk 信息，chunk 的顺序是按照行序来的
        {
          chunkId: "chuxxx", // chunkId, chu 开头，与行对应
          count: 10, // chunk中行的数量
          firstId: "recxxx", // chunk中第一行的id
          lastId: "recxxx", // chunk中最后一行的id
        }
      ],
      columns: [
        {
          columnId: "colxxx", // col 开头的小写随机字符串当做列id
          hidden: false, // 是否隐藏 可能有些视图要隐藏
        }
      ],
      ca: 1687273232332, // 创建时间时间戳
      ua: 1687273232332, // 最后更新时间时间戳
    }
  ],
  fieldMap: {
    "fldxxx": {
      id: "fldxxx", // 字段id
      name: "name", // 字段名称
      type: 1, // 字段类型
      property: { // 字段的配置不同的字段不一样的值，应作为枚举
        defaultValue: 'xx' // 默认值
      }
    }
  },
  recordMap: {
    "recxxx": {
        id: "recxxx", // 行id
        v: 100, // 版本号
        data: {
            "fldxxx": [ // 字段id: 值
              {
                t: "", //字段的文本值
                data: {
                  value: 100, // 字段的值,有可能不是字符串
                },
                v: 100, // 版本号
              }
            ]
        },
        oph: [], // 行操作记录
        ca: 1687273232332, // 创建时间时间戳
        ua: 1687273232332, // 最后更新时间时间戳
        rh: [100, 21], // 版本号历史
    }
  },
  v: 100 // 版本号
}

```
