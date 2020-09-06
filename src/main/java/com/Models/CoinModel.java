package com.Models;

public class CoinModel {
    public String id;
    public String symbol;
    public String name;
    public float publicInterestScore;
    public int coinGeckoRank;
    public String platform;
    public String bornDate;
    public String algorithm;

    public CoinModel(String id, String symbol, String name, float public_interest_score, int coingecko_rank, String asset_platform_id, String genesis_date, String hashing_algorithm) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.publicInterestScore = public_interest_score;
        this.coinGeckoRank = coingecko_rank;
        this.platform = asset_platform_id;
        this.bornDate = genesis_date;
        this.algorithm = hashing_algorithm;
    }
}
