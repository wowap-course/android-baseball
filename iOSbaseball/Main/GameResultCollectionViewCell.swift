//
//  GameResultCollectionViewCell.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/28/24.
//

import UIKit

class GameResultCollectionViewCell: UICollectionViewCell {
    @IBOutlet weak var countLabel: UILabel!
    @IBOutlet weak var ballLabel: UILabel!
    @IBOutlet weak var strikeLabel: UILabel!
    @IBOutlet weak var inputLabel: UILabel!
    
    func configure(_ GameResult: GameResult){
        countLabel.text = "\(String(GameResult.gameCount)) 번째 도전"
        ballLabel.text = "볼 : \(String(GameResult.ball))"
        strikeLabel.text = "스트라이크 : \(String(GameResult.strike))"
        inputLabel.text = "입력 : \(String(GameResult.number))"
    }
    
}
