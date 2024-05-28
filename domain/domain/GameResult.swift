//
//  GameResult.swift
//  domain
//
//  Created by KimMinSeok on 5/28/24.
//

import Foundation

public struct GameResult: Hashable{
    public let gameCount : Int
    public let strike : Int
    public let ball : Int
    public let number : Int
    
    public init(gameCount: Int, strike: Int, ball: Int, number: Int) {
        self.gameCount = gameCount
        self.strike = strike
        self.ball = ball
        self.number = number
    }
}

extension GameResult {
    static public var list: [GameResult] = [
    ]
}
