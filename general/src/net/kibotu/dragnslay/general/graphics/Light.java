package net.kibotu.dragnslay.general.graphics;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.sun.istack.internal.NotNull;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class Light {

    public Vector3 position;
    public Vector3 direction;
    public Type type;
    public boolean isOn;
    protected String name;
    private PhongMaterial material;
    private String positionName;
    private String isOnName;
    private String typeName;
    private String directionName;

    public Light ( String name, Vector3 position, Vector3 direction, Type type, boolean isOn ) {
        this.name = name;
        this.position = position;
        this.direction = direction;
        this.type = type;
        this.isOn = isOn;
        this.material = PhongMaterial.createDefaultMaterial();

        positionName = name + ".position";
        isOnName = name + ".isOn";
        typeName = name + ".type";
        directionName = name + ".direction";
    }

    public Light ( String name, float posX, float posY, float posZ, float dirX, float dirY, float dirZ ) {
        this( name, new Vector3( posX, posY, posZ ), new Vector3( dirX, dirY, dirZ ), Type.u_DirectionalLight, true );
    }

    public Light ( final Type type, final int posX, final int posY, final int posZ, final int dirX, final int dirY, final int dirZ ) {
        this( type.name(), posX, posY, posZ, dirX, dirY, dirZ );
    }

    public void apply ( @NotNull ShaderProgram program ) {
        program.setUniformf( positionName, position.x, position.y, position.z );

        switch ( type ) {
            case u_DirectionalLight:
                program.setUniformf( directionName, direction.x, direction.y, direction.z );
                break;
            case u_PointLight:
                break; // TODO implement me

            case u_SpotLight:
                break; // TODO implement me
        }
        program.setUniformi( isOnName, isOn ? 1 : 0 );
        program.setUniformi( typeName, Type.u_DirectionalLight.ordinal() );
        material.apply( program );
    }

    public enum Type {
        u_DirectionalLight, u_PointLight, u_SpotLight
    }
}
