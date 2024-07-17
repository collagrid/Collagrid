export const getData = async (dstId: string) => {
    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json, text/plain, */*");
    myHeaders.append("Accept-Language", "zh-CN,zh-TW;q=0.9,zh;q=0.8,de-DE;q=0.7,de;q=0.6,en;q=0.5,en-US;q=0.4");
    myHeaders.append("Connection", "keep-alive");
    myHeaders.append("Cookie", "Webstorm-44d4908=e6e23d3c-e1a2-4e75-aba4-d2283238b17b; __client_uat=1706246154; __clerk_db_jwt=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXYiOiJkdmJfMmJUaW9YdkdqcXhIUVBWUlNuWnhZY2tpMUR0IiwiaWQiOiJjbGllbnRfMmJUam5ncThwaVltNXN1UlpqZGlQMmhmUE9OIiwicm90YXRpbmdfdG9rZW4iOiJjcnV4ZGJtdWZ6em5kaXFkaHpqeDBkMmJoY3U2YTQzcXUzanA5MnBhIn0.NRGs0JKiELiskhxPiI6hyD2YcSZk1bgNVZeWEKZCdSlCxYpjgNbqWVfG6AaiyHdHcAloASC7Yum9Tl103eognPyBhMyMn7ObBXA3GOz09FQ8pjVDOMggrte7NtZ2vSpWAlCehG8O-W6uEyfZb_yaEt-1SwjhBEEuayrJiT7w_-gudzehQGnRkHG-y-k_TDSVQn1ScbS40aGPMzmZF6SBzBgMt6nmrSp42lw_4gIqDBrwJILSonWDSoACFCgssB6Gdr3uQAfKq05XPfapgR1f7UqSEA2kq_qd6ri5k7956wIlKddl3ehWiDiZUYjKWOSRs24SS3TCpzsPp3LmS7UhoQ; __session=eyJhbGciOiJSUzI1NiIsImNhdCI6ImNsX0I3ZDRQRDExMUFBQSIsImtpZCI6Imluc18yYXlxcVdRSmdmNnNvR0FobVJQeWpWVXZXSlciLCJ0eXAiOiJKV1QifQ.eyJhenAiOiJodHRwOi8vbG9jYWxob3N0OjMwMDEiLCJleHAiOjE3MDY1MzAwNTksImlhdCI6MTcwNjUyOTk5OSwiaXNzIjoiaHR0cHM6Ly9icmllZi1zdGlua2J1Zy0zNi5jbGVyay5hY2NvdW50cy5kZXYiLCJuYmYiOjE3MDY1Mjk5ODksInNpZCI6InNlc3NfMmJUanFhb0R4cnZDOGd5NGNnempTZlZ2WU1tIiwic3ViIjoidXNlcl8yYk5OV2pXTWc1WTdqU21SeXF1N3NxZlRlVXkifQ.ktq256epBu39rgyTkoYJWjBh2oa7KiBkq_llh4bmK0LgWwS1wVOI3MWV9fMOF-Dtbj6Hi1XhnkBMxd0JsxUfm4IbpCEJoyCcp8V3XuWdgrYWItMUpYKko0Cyzu3bIMxoHLKRxOOqBdiX7ulO2FuDMrd6cWKvVjZS4OPbDUW_d0euuLmEIlOdG00oND2YaEtPE_G9LCyeKNlN0rgCHpqgEjNkPQMeJVEBW1h5tALOqmSprdUvTig5ybI_tCVMwQ01pME2JgXzf9au2zDWawRbp-vyF5W2Tl3hC2YpbyioXeB9jAqKjKIrRrCxl7MJb-7KNkGQDwpGN1ouRJtOKDwDdA; Webstorm-44d490a=0463b011-f66c-412e-9f19-e4ec72cda440; Hm_lvt_38525fdac4b5d4403900b943d4e7dd91=1708001605; username=admin; rememberMe=true; password=SAEGkSyUoe266CJ7wMP3gkag3n5hMhO7NGFufyiv6Js4Opt61QvxyxZWEWKRYqP5TSSV95lg+SFfVDHLNq6UXw==; Admin-Token=eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjA0N2U5YmI1LWQ5MGMtNDE4ZS1hNzdlLTQ5MjdjMjliMmYyZCJ9.ak2sqHl2AAYf0JGXeSLMinffokjAG_PVZdU4ExqZpszmzba5iT_i8J7OONGsA75Dgb2-QffCDVhJUMnYoHx9nQ; XSRF-TOKEN=44d56b6a-956c-4ffc-bc4f-ff74d013d23d; _ga=GA1.1.1299656078.1718261096; _ga_VPPB82K220=GS1.1.1718433160.4.0.1718433160.0.0.0; SESSION=MGQ2MWJiNjQtNzdkOS00Mjc5LWE3YTAtMjRiYTNkNGNhYzMx; lang=zh-CN");
    myHeaders.append("Sec-Fetch-Dest", "empty");
    myHeaders.append("Sec-Fetch-Mode", "cors");
    myHeaders.append("Sec-Fetch-Site", "same-origin");
    myHeaders.append("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
    myHeaders.append("X-Socket-Id", "hZWFEKLtsfzgDnpYAAE9");
    myHeaders.append("X-Space-Id", "spcu1gwV9l431");
    myHeaders.append("X-XSRF-TOKEN", "44d56b6a-956c-4ffc-bc4f-ff74d013d23d");
    myHeaders.append("sec-ch-ua", "\"Google Chrome\";v=\"125\", \"Chromium\";v=\"125\", \"Not.A/Brand\";v=\"24\"");
    myHeaders.append("sec-ch-ua-mobile", "?0");
    myHeaders.append("sec-ch-ua-platform", "\"macOS\"");

    const requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow"
    };

    try {
        const response = await fetch(
            `api/v1/branchDst/datasheets/${dstId}/dataDrink?branchId=0.01`
            , requestOptions as RequestInit);
        if (!response.ok) {
            throw new Error('Network response was not ok.');
        }
        const result = await response.json();
        console.log(result);
        return result;
    } catch (error) {
        console.error('Fetch Error:', error);
    }
};

export const doOp = async (op: any) => {
    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json, text/plain, */*");
    myHeaders.append("Accept-Language", "zh-CN,zh-TW;q=0.9,zh;q=0.8,de-DE;q=0.7,de;q=0.6,en;q=0.5,en-US;q=0.4");
    myHeaders.append("Connection", "keep-alive");
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Cookie", "Webstorm-44d4908=e6e23d3c-e1a2-4e75-aba4-d2283238b17b; __client_uat=1706246154; __clerk_db_jwt=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXYiOiJkdmJfMmJUaW9YdkdqcXhIUVBWUlNuWnhZY2tpMUR0IiwiaWQiOiJjbGllbnRfMmJUam5ncThwaVltNXN1UlpqZGlQMmhmUE9OIiwicm90YXRpbmdfdG9rZW4iOiJjcnV4ZGJtdWZ6em5kaXFkaHpqeDBkMmJoY3U2YTQzcXUzanA5MnBhIn0.NRGs0JKiELiskhxPiI6hyD2YcSZk1bgNVZeWEKZCdSlCxYpjgNbqWVfG6AaiyHdHcAloASC7Yum9Tl103eognPyBhMyMn7ObBXA3GOz09FQ8pjVDOMggrte7NtZ2vSpWAlCehG8O-W6uEyfZb_yaEt-1SwjhBEEuayrJiT7w_-gudzehQGnRkHG-y-k_TDSVQn1ScbS40aGPMzmZF6SBzBgMt6nmrSp42lw_4gIqDBrwJILSonWDSoACFCgssB6Gdr3uQAfKq05XPfapgR1f7UqSEA2kq_qd6ri5k7956wIlKddl3ehWiDiZUYjKWOSRs24SS3TCpzsPp3LmS7UhoQ; __session=eyJhbGciOiJSUzI1NiIsImNhdCI6ImNsX0I3ZDRQRDExMUFBQSIsImtpZCI6Imluc18yYXlxcVdRSmdmNnNvR0FobVJQeWpWVXZXSlciLCJ0eXAiOiJKV1QifQ.eyJhenAiOiJodHRwOi8vbG9jYWxob3N0OjMwMDEiLCJleHAiOjE3MDY1MzAwNTksImlhdCI6MTcwNjUyOTk5OSwiaXNzIjoiaHR0cHM6Ly9icmllZi1zdGlua2J1Zy0zNi5jbGVyay5hY2NvdW50cy5kZXYiLCJuYmYiOjE3MDY1Mjk5ODksInNpZCI6InNlc3NfMmJUanFhb0R4cnZDOGd5NGNnempTZlZ2WU1tIiwic3ViIjoidXNlcl8yYk5OV2pXTWc1WTdqU21SeXF1N3NxZlRlVXkifQ.ktq256epBu39rgyTkoYJWjBh2oa7KiBkq_llh4bmK0LgWwS1wVOI3MWV9fMOF-Dtbj6Hi1XhnkBMxd0JsxUfm4IbpCEJoyCcp8V3XuWdgrYWItMUpYKko0Cyzu3bIMxoHLKRxOOqBdiX7ulO2FuDMrd6cWKvVjZS4OPbDUW_d0euuLmEIlOdG00oND2YaEtPE_G9LCyeKNlN0rgCHpqgEjNkPQMeJVEBW1h5tALOqmSprdUvTig5ybI_tCVMwQ01pME2JgXzf9au2zDWawRbp-vyF5W2Tl3hC2YpbyioXeB9jAqKjKIrRrCxl7MJb-7KNkGQDwpGN1ouRJtOKDwDdA; Webstorm-44d490a=0463b011-f66c-412e-9f19-e4ec72cda440; Hm_lvt_38525fdac4b5d4403900b943d4e7dd91=1708001605; username=admin; rememberMe=true; password=SAEGkSyUoe266CJ7wMP3gkag3n5hMhO7NGFufyiv6Js4Opt61QvxyxZWEWKRYqP5TSSV95lg+SFfVDHLNq6UXw==; Admin-Token=eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjA0N2U5YmI1LWQ5MGMtNDE4ZS1hNzdlLTQ5MjdjMjliMmYyZCJ9.ak2sqHl2AAYf0JGXeSLMinffokjAG_PVZdU4ExqZpszmzba5iT_i8J7OONGsA75Dgb2-QffCDVhJUMnYoHx9nQ; XSRF-TOKEN=44d56b6a-956c-4ffc-bc4f-ff74d013d23d; _ga=GA1.1.1299656078.1718261096; _ga_VPPB82K220=GS1.1.1718433160.4.0.1718433160.0.0.0; SESSION=MGQ2MWJiNjQtNzdkOS00Mjc5LWE3YTAtMjRiYTNkNGNhYzMx; lang=zh-CN; XSRF-TOKEN=2119d749-0b14-45c9-b523-6660407bb598");
    myHeaders.append("Origin", "http://localhost:3000");
    myHeaders.append("Sec-Fetch-Dest", "empty");
    myHeaders.append("Sec-Fetch-Mode", "cors");
    myHeaders.append("Sec-Fetch-Site", "same-origin");
    myHeaders.append("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
    myHeaders.append("X-Socket-Id", "hZWFEKLtsfzgDnpYAAE9");
    myHeaders.append("X-Space-Id", "spcu1gwV9l431");
    myHeaders.append("X-XSRF-TOKEN", "44d56b6a-956c-4ffc-bc4f-ff74d013d23d");
    myHeaders.append("sec-ch-ua", "\"Google Chrome\";v=\"125\", \"Chromium\";v=\"125\", \"Not.A/Brand\";v=\"24\"");
    myHeaders.append("sec-ch-ua-mobile", "?0");
    myHeaders.append("sec-ch-ua-platform", "\"macOS\"");

    const raw = JSON.stringify(op);

    const requestOptions: any = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    try {
        const response = await fetch("api/v1/internal/branch/ops", requestOptions);
        if (!response.ok) {
            throw new Error('Network response was not ok.');
        }
        const result = await response.json();
        return result;
    } catch (error) {
        console.error('Fetch Error:', error);
    }
};


