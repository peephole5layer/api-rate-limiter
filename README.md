# 🚦 API Rate Limiter Service

A **Spring Boot–based API Rate Limiter** that protects APIs from overuse by controlling request flow per user/IP using **Redis caching**.  
Ensures **fair usage, stability, and protection** of APIs with smart request throttling.  

---

## ✨ Features
- ⚡ **Request Throttling** → Limit requests per user/IP (e.g., 100 requests per minute).  
- 🔄 **Auto Reset Counters** → Limits reset every minute automatically.  
- 🛡 **API Protection** → Prevents abuse & ensures fair resource usage.  
- 📡 **Redis Powered** → High-performance caching for request counts.  
- 🧩 **Plug & Play** → Works with embedded Redis, no external setup needed.  

---
## 📌 Use Cases

 1. 🌐 Public APIs (Prevent Abuse)
 2. 🔑 Authentication endpoints
 3. 💳 Payment gateways
 4. 💬 Messaging systems

## 🏗 Project Architecture

```mermaid
flowchart TD
    A[Client Request] --> B[RateLimiterFilter]
    B -->|Check User/IP| C[RateLimiterService]
    C -->|Request Count in Redis| D[Redis Store]
    C -->|Allowed| E[API Controller]
    C -->|Blocked| F[429 Too Many Requests]
    E --> G[✅ Success Response]
    F --> H[❌ Error Response]


