//
//  File.swift
//  domain
//
//  Created by KimMinSeok on 5/28/24.
//

import Foundation

struct GameResult: Hashable{
    let strike : Int
    let Ball : Int
    let Number : Int
}

extension GameResult {
    static let list: [GameResult] = [
        GameResult(strike: 1, Ball: 2, Number: 123),
        GameResult(strike: 0, Ball: 0, Number: 456),
        GameResult(strike: 0, Ball: 2, Number: 126)
    ]
}
