package com.pavane.ark;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.utils.Array;

public class ArkMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GamePhysics phy;
	ShapeRenderer shapeDebugger = new ShapeRenderer();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("module.jpg");
		phy = new GamePhysics();
		phy.create();
		
		phy.addBody( 10, 5, BodyType.StaticBody, 5, 2, new Vector2( 5, 2 ), 0 );
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Array<Body> bodies = null;
		phy._world.getBodies( bodies );
		
		for( int b = 0; b < bodies.size; b++ ){
			batch.begin();
			Vector2 pos = bodies.items[b].getPosition();
			batch.draw( img, pos.x, pos.y );
			batch.end();
		}
	}
}
