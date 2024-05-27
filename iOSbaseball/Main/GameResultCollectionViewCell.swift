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
        countLabel.text = String(GameResult.gameCount)
        ballLabel.text = String(GameResult.ball)
        strikeLabel.text = String(GameResult.strike)
        inputLabel.text = String(GameResult.number)
    }
    
}
