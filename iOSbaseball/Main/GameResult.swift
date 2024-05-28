//
//  File.swift
//  domain
//
//  Created by KimMinSeok on 5/28/24.
//

import Foundation

struct GameResult: Hashable{
    let gameCount : Int
    let strike : Int
    let ball : Int
    let number : Int
}

extension GameResult {
    static var list: [GameResult] = [
        GameResult(gameCount : 1, strike: 1, ball: 2, number: 123),
        GameResult(gameCount : 2, strike: 0, ball: 0, number: 456),
        GameResult(gameCount : 3, strike: 0, ball: 2, number: 126),
    ]
}
