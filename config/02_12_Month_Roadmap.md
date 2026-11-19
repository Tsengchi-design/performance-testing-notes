# 性能测试工程师12个月整体学习计划（原始路线基线）

- 文档类型：全年路线权威基线
- 来源：用户于 2026-11-18 在当前对话完整提供的初始12个月计划
- 版本：V1.0（忠实整理，不改变原路线）
- 适用目标：由具有6年测试经验、熟悉JMeter和接口测试的工程师，成长为能够独立定位性能瓶颈的高级性能测试/性能工程师，并保留测试开发方向的能力。
- 时间投入：工作日每天1小时（每周5小时）；周六6小时（理论3+实践3）；周日6小时（理论2+实践4）；总计约17小时/周，理论约7小时、实践约10小时。

> **基线与执行差异说明：** 原始路线按 Linux → 网络 → Java/JVM → MySQL/Redis → 可观测性 → Docker/综合项目安排；当前实际课程已优先推进 Java。该执行差异仅在《学习进度总档案》中记录，不修改本原始52周路线；后续是否调整顺序须经用户确认。

## 一、12个月能力目标

完整性能工程链路：业务需求 → 性能测试方案 → JMeter脚本 → 场景设计 → 压测执行 → Linux监控 → JVM分析 → 数据库分析 → 链路追踪 → 定位瓶颈 → 优化建议 → 优化验证 → 性能测试报告。

原计划能力目标（自评参考而非客观认证）：JMeter 8–9/10；接口测试 8/10；Linux 7/10；网络 7/10；Java 6–7/10；JVM 6–7/10；MySQL 6–7/10；Redis 5–6/10；Docker 5–6/10；Prometheus/Grafana 6/10；链路追踪 5–6/10；Kubernetes 3–4/10；Python够用即可。优先培养性能问题定位能力，而不是堆叠工具。

## 二、全年六阶段概览

| 阶段 | 周次 | 重点 |
|---|---|---|
| 第一阶段 | 第1–8周 | Linux与性能基础 |
| 第二阶段 | 第9–16周 | 网络、HTTP、TCP |
| 第三阶段 | 第17–28周 | Java、JVM、GC、Arthas |
| 第四阶段 | 第29–36周 | MySQL、Redis |
| 第五阶段 | 第37–44周 | 可观测性与性能分析 |
| 第六阶段 | 第45–52周 | Docker、微服务基础、综合项目与求职准备 |

## 三、第一阶段：第1–8周 Linux + 性能基础

### 第1周：Linux基础
- 目录结构、文件、用户、权限、SSH、环境变量、Shell基础。
- 命令：`ls`、`cd`、`pwd`、`cp`、`mv`、`rm`、`find`、`grep`、`awk`、`sed`、`cat`、`less`、`tail`、`head`、`chmod`、`chown`。
- 实践：安装 Ubuntu 虚拟机、WSL 或云服务器，完成创建用户 → 配置权限 → 创建日志 → 搜索日志 → 修改权限。

### 第2周：进程和资源
- 命令：`ps`、`top`、`htop`、`free`、`vmstat`、`uptime`、`kill`、`nice`。
- 理解 CPU、Load Average、Memory、Swap、Process、Thread。
- 实验：运行 Java 程序并使用 JMeter 压测，结合 `top`、`vmstat`、`free` 观察 CPU 和内存变化。

### 第3周：磁盘与 IO
- 命令：`df`、`du`、`iostat`、`iotop`、`sar`。
- 理解磁盘空间与磁盘 IO 的区别、IOPS、Throughput、IO Wait。

### 第4周：Linux网络
- 命令：`ss`、`netstat`、`lsof`、`ping`、`traceroute`、`curl`。
- 理解端口、TCP连接、CLOSE_WAIT、TIME_WAIT。

### 第5–6周：Shell
- 变量、if、for、while、函数、管道、重定向。
- 实践：编写自动收集服务器 CPU、内存、磁盘、网络信息的脚本。

### 第7–8周：Linux性能分析
- 综合制作 Linux 性能监控脚本：输入 PID，输出 CPU、Memory、Load、Disk IO、Network、Thread 信息。
- 阶段产出：`linux-performance-lab` 仓库或目录。

## 四、第二阶段：第9–16周 网络 + HTTP + TCP

### 第9周：HTTP
- 请求、响应、Header、Cookie、Session、Keep-Alive、Cache。

### 第10周：HTTPS/TLS
- 理解 DNS → TCP → TLS → HTTP 的关系；使用 `curl`、`tcpdump` 观察请求。

### 第11–12周：TCP
- 三次握手、四次挥手、ACK、SYN、RST、TIME_WAIT、CLOSE_WAIT、滑动窗口、重传。

### 第13周：抓包
- Wireshark、tcpdump；能通过抓包分析一次 HTTP 请求。

### 第14周：连接问题
- 连接池、Keep-Alive、TIME_WAIT、CLOSE_WAIT、连接数、文件描述符。

### 第15周：网络性能
- 延迟、带宽、QPS、RTT、丢包、TCP重传。

### 第16周：综合实验
- 搭建 JMeter → Nginx → Java；压测、tcpdump抓包、Linux资源分析。
- 阶段目标：解释一次 HTTP 请求从客户端到服务器的完整过程。

## 五、第三阶段：第17–28周 Java + JVM

### 第17–20周：Java基础（原始路线中的模块）
- 集合：ArrayList、HashMap、ConcurrentHashMap。
- 多线程：Thread、Runnable、Executor、ThreadPoolExecutor。
- 并发：synchronized、Lock、CAS、volatile。
- IO：BIO、NIO。

> 注：这里的“第17–20周”是原始计划的周次，与当前实际 Java 日课“Day17–Day20”不是同一编号体系。

### 第21–24周：JVM
- JVM内存结构、Heap、Stack、Metaspace、ClassLoader、GC。
- 了解 Serial、CMS、G1、ZGC，不要求深入 JVM 源码；CMS 属历史收集器，学习时应注明版本背景。

### 第25周：GC
- Young GC、Old GC、Full GC、GC频率、GC停顿；制造 GC 异常并观察 GC 日志。

### 第26周：JVM工具
- `jps`、`jstat`、`jmap`、`jstack`、`jcmd`；JFR。

### 第27–28周：Arthas
- `dashboard`、`thread`、`watch`、`trace`、`stack`、`monitor`、`profiler`。
- 综合实验：制造 Java 接口响应时间异常，通过 JMeter → Linux → JVM → 线程 → Arthas → 代码定位。

## 六、第四阶段：第29–36周 MySQL + Redis

### 第29–31周：MySQL
- 索引、B+Tree、联合索引、Explain、回表、覆盖索引、慢SQL。

### 第32–33周：事务
- ACID、隔离级别、MVCC、锁；目标是分析数据库性能瓶颈，不要求过度深入实现细节。

### 第34周：MySQL性能
- Buffer Pool、CPU、IO、Connection Pool、慢查询。

### 第35周：Redis
- String、Hash、List、Set、ZSet、Pipeline、Lua。

### 第36周：Redis性能
- BigKey、HotKey、缓存穿透、缓存击穿、缓存雪崩。

## 七、第五阶段：第37–44周 可观测性 + 性能分析

### 第37–38周：Prometheus
- Metric、Counter、Gauge、Histogram、Summary；重点理解 P95/P99。

### 第39–40周：Grafana
- 制作 JVM Dashboard：CPU、Memory、GC、Heap、Thread、TPS、RT、P95、P99、Error Rate。

### 第41周：日志
- 选择一种日志体系，练习从日志定位问题。

### 第42周：链路追踪
- SkyWalking、Jaeger、OpenTelemetry 三选一深入。

### 第43–44周：性能分析闭环
- 模拟接口性能下降：JMeter → Prometheus → Grafana → Trace → Java → JVM → MySQL → 定位问题。

## 八、第六阶段：第45–52周 Docker + 综合项目 + 求职

### 第45–47周：Docker
- Image、Container、Volume、Network、Dockerfile、Compose。

### 第48–49周：微服务基础
- Gateway、Service、Redis、MySQL、MQ；理解基本架构，无须成为微服务专家。

### 第50–52周：综合项目
- 架构：JMeter → Nginx → Gateway → Java Service → Redis/MySQL，接入 Prometheus/Grafana、Trace/Logs。
- 人为制造并分析六类场景：CPU瓶颈、JVM GC瓶颈、线程池瓶颈、数据库慢SQL、Redis瓶颈、网络延迟。
- 最终产出：《XX系统性能测试与性能分析报告》。

## 九、全年五类可交付成果

1. Git仓库 `performance-engineering-lab`，建议目录：`linux/`、`network/`、`java/`、`jvm/`、`mysql/`、`redis/`、`jmeter/`、`observability/`。
2. JMeter项目：脚本、参数化、数据构造、场景设计、监控、报告。
3. 至少10个性能问题案例：CPU、GC、慢SQL、线程池、连接池、Redis、网络、IO、锁竞争、下游服务。
4. 性能测试方法论：需求分析 → 指标确定 → 容量估算 → 场景设计 → 数据准备 → 脚本开发 → 环境检查 → 基准测试 → 负载测试 → 压力测试 → 稳定性测试 → 瓶颈分析 → 优化 → 回归。
5. 可用于面试的端到端性能工程项目：能清楚讲解场景设计、执行、监控、定位、优化验证的完整闭环。

## 十、每周执行模板

| 时间 | 原计划安排 |
|---|---|
| 周一 | 理论1小时 |
| 周二 | 理论与小实验1小时 |
| 周三 | 理论1小时 |
| 周四 | 源码、原理或深入1小时 |
| 周五 | 总结并整理Markdown笔记1小时 |
| 周六 | 大型实验3–6小时（总投入6小时） |
| 周日 | 大型实验、复盘4–6小时（总投入6小时） |

课程应联系实际证券项目：为什么选择某并发量、TPS/RT目标如何确定、如何定位瓶颈、监控什么、为何预热、为何做稳定性测试、数据量如何影响性能。不得将公司内部代码、架构、敏感数据上传到个人项目或外部平台。

## 十一、AI辅助原则

从第6个月开始逐步将AI用于 JMeter脚本、日志分析、GC日志解释、Shell、SQL、压测报告、测试数据、Python工具、异常指标分析。原则：AI帮助编写，学习者必须能够解释和验证，不照搬结果。

## 十二、季度能力验收

| 节点 | 关键问题 |
|---|---|
| 第3个月 | 能否用Linux定位一个性能问题？ |
| 第6个月 | 能否通过JMeter + JVM定位Java应用问题？ |
| 第9个月 | 能否从JMeter一路分析到数据库？ |
| 第12个月 | 能否独立完成完整性能测试项目并解释瓶颈？ |

## 十三、职业发展与第二年方向

- 第6个月开始每月调研岗位：高级性能测试工程师、性能测试工程师、性能工程师、测试开发工程师、测试开发（性能方向）、质量工程师、金融科技测试工程师；依据岗位JD决定补强Java/JVM、K8s或Python。
- 职业目标优先级：达到高级性能测试岗位能力 → 摆脱纯外包测试定位 → 争取甲方/金融科技/大型互联网/软件公司的技术型测试岗位 → 在市场条件允许时争取15K–20K+，不保证薪资结果。
- 第二年再系统拓展 Kubernetes、微服务、OpenTelemetry、云原生性能、AI应用性能；原计划第12个月已有 Docker 基础，不应误解为第二年才首次接触 Docker。
- 长期方向：高级性能测试、性能工程师、测试开发，进一步走向性能专家/技术专家。

## 十四、执行与版本管理规则

1. 本文件为用户提供的原始12个月路线的结构化归档，不改变阶段顺序、周次、范围或验收目标。
2. 每日 Java 课程的 Day 编号与原计划 Week 编号严格区分。
3. 实际已完成的课程、复验和进度以《学习进度总档案》及最新明确验收为准；不因原路线周次而否认已完成的学习。
4. 后续如需调整先说明原因、征得用户同意，并另行记录变更；不覆盖本基线。
5. 原文部分阶段目标有概括性表述；本文件仅做结构化整理，未擅自增补逐日课程。
