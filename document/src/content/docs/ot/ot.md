---
title: OT 操作
description: OT 操作数据结构以及定义
---

OT 遵循下面的数据结构
```json5
{
  "type": "CLIENT_ROOM_CHANGE", // 区分来自服务端还是客户端
  "roomId": "dstxxx", // 房间id，focus 在一个表内即可认为加入一个房间
  "changesets": [
    {
      "messageId": "xxxx", // 消息id 确保不重复
      "baseRevision": 0, // 操作前的 revision
      "resourceId": "dstxxx", // datasheet id
      "resourceType": 0, // 操作对象的类型
      "operations": [
        {
          "cmd": "SetRecords", // 封装的命令
          "actions": [ // 具体的 OP
            {
              "n": "OI", // 名称，操作类型
              "p": [  // json path
                "recordMap",
                "recElVSnB0XeN",
                "data",
                "fldr6yGPipHaR"
              ],
              "oi": [ // 操作的值
                {
                  "type": 1,
                  "text": "gh"
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}
```
